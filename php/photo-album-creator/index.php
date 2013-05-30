<?
$BASE_URL = 'http://example.com/';

/* function:  generates thumbnail */
function make_thumb($src,$dest,$desired_width) {
	/* read the source image */
	$source_image = imagecreatefromjpeg($src);
	$width = imagesx($source_image);
	$height = imagesy($source_image);
	/* find the "desired height" of this thumbnail, relative to the desired width  */
	$desired_height = floor($height*($desired_width/$width));
	/* create a new, "virtual" image */
	$virtual_image = imagecreatetruecolor($desired_width,$desired_height);
	/* copy source image at a resized size */
	imagecopyresized($virtual_image,$source_image,0,0,0,0,$desired_width,$desired_height,$width,$height);
	/* create the physical thumbnail image to its destination */
	imagejpeg($virtual_image,$dest);
}

/* function:  returns files from dir */
function get_files($images_dir,$exts = array('jpg')) {
	$files = array();
	if($handle = opendir($images_dir)) {
		while(false !== ($file = readdir($handle))) {
			$extension = strtolower(get_file_extension($file));
			if($extension && in_array($extension,$exts)) {
				$files[] = $file;
			}
		}
		closedir($handle);
	}
	return $files;
}

/* function:  returns a file's extension */
function get_file_extension($file_name) {
	return substr(strrchr($file_name,'.'),1);
}
?>

<html>
	<head>
		<title>Richard Clooney's Photo Gallery!</title>
		<style type="text/css">
			.clear {
				clear:both;
			}

			.photo-link {
				padding:5px; margin:5px; border:1px solid #ccc; display:block; width:200px; float:left;
			}

			.photo-link:hover {
				border-color:#999;
			}
		</style>
	</head>
	<body>

		<h2><? echo file_get_contents($BASE_URL . 'quotegenerator.php'); ?></h2>

		<?
		/** settings **/
		$images_dir = './';
		$thumbs_dir = './thumbs/';
		$thumbs_width = 200;
		$images_per_row = 5;

		/** verify thumbs dir **/
		if(!is_dir($thumbs_dir)) {
			mkdir($thumbs_dir);
		}

		/** generate photo gallery **/
		$image_files = get_files($images_dir, array('jpg', 'avi', 'mov'));
		if(count($image_files)) {
			$index = 0;
			foreach($image_files as $index=>$file) {
				$file_parts = pathinfo($file);
				$index++;

				// if image, generate and display thumb
				if (in_array(strtolower($file_parts['extension']),array('jpg'))) {
					$thumbnail_image = $thumbs_dir . $file_parts['filename'] . '-thumb.' . $file_parts['extension'];
					if(!file_exists($thumbnail_image)) {
						$extension = get_file_extension($thumbnail_image);
						if($extension) {
							make_thumb($images_dir.$file,$thumbnail_image,$thumbs_width);
						}
					}
					echo '<a href="',$images_dir.$file,'" class="photo-link smoothbox" rel="gallery"><img src="',$thumbnail_image,'" /></a>';
				}

				// if video, display hardcoded video thumb
				if (in_array(strtolower($file_parts['extension']),array('avi', 'mov'))) {
					echo '<a href="',$images_dir.$file,'"><img width="200" height="150" src="http://cdn1.iconfinder.com/data/icons/refresh_cl/256/Hardware/Video_Camera.png" /></a>';
				}

				if($index % $images_per_row == 0) {
					echo '<div class="clear"></div>';
				}
			}
			echo '<div class="clear"></div>';
		}
		else {
			echo '<p>There are no images in this gallery.</p>';
		}
		?>

		<form>
			<input value="Go back" type="button" onClick="parent.location='<? echo dirname($_SERVER['REQUEST_URI']); ?>'">
		</form>
	</body>
</html>
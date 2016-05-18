import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Main {
  private static final String HUE_BRIDGE_ADDRESS = "http://xxx.xxx.xxx.xxx/api/";
  private static final String USERNAME = "INSERT_USERNAME_HERE";

  public static void main(String[] args) {
//    System.out.println(createUser("Jarvis", ""));
//    System.out.println(deleteUser("8be93Hwh8i3eqyJdcXg1NEspPPdW5kl1RBWFuchQ"));

//    System.out.println(getConfiguration());
//    System.out.println(getFullState());
//    System.out.println(getLights());
    System.out.println(toggleLight(1, false));
  }

  /**
   * Create a new user.
   *
   * @param applicationName Name of your application
   * @param deviceName Name of the device
   * @return
   *
   * @see <a href="http://www.developers.meethue.com/documentation/configuration-api#71_create_user">http://www.developers.meethue.com/documentation/configuration-api#71_create_user</a>
   */
  public static String createUser(String applicationName, String deviceName) {

    // Construct device type
    String deviceType = applicationName.trim() + (deviceName == null || deviceName.trim().length() == 0 ? "" : "#" + deviceName.trim());


    // Configure the request properties
    String url = HUE_BRIDGE_ADDRESS;    // POST directly to API root
    String json = "{\"devicetype\": \"" + deviceType + "\"}";
    MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    // Construct the POST request
    OkHttpClient client = new OkHttpClient();
    RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, json);
    Request request = new Request.Builder()
        .url(url)
        .post(body)
        .build();

    // Make the call
    try {
      Response response = client.newCall(request).execute();
      return response.body().string();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  /**
   * Delete a user by username.
   *
   * @param usernameToDelete Username of the user to delete
   * @return
   *
   * @see <a href="http://www.developers.meethue.com/documentation/configuration-api#74_delete_user_from_whitelist">http://www.developers.meethue.com/documentation/configuration-api#74_delete_user_from_whitelist</a>
   */
  public static String deleteUser(String usernameToDelete) {

    // Configure the request properties
    String url = HUE_BRIDGE_ADDRESS + USERNAME + "/config/whitelist/" + usernameToDelete;

    // Construct the DELETE request
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
        .url(url)
        .delete()
        .build();

    // Make the call
    try {
      Response response = client.newCall(request).execute();
      return response.body().string();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  public static String toggleLight(int lightId, boolean turnOn) {

    // Configure the request properties
    String url = HUE_BRIDGE_ADDRESS + USERNAME + "/lights/" + lightId + "/state";
    String json = "{\"on\": " + turnOn + "}";
    MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    // Construct the POST request
    OkHttpClient client = new OkHttpClient();
    RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, json);
    Request request = new Request.Builder()
        .url(url)
        .put(body)
        .build();

    // Make the call
    try {
      Response response = client.newCall(request).execute();
      return response.body().string();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  public static String getConfiguration() {
    return get(HUE_BRIDGE_ADDRESS + USERNAME + "/config");
  }

  public static String getFullState() {
    return get(HUE_BRIDGE_ADDRESS + USERNAME);
  }

  public static String getLights() {
    return get(HUE_BRIDGE_ADDRESS + USERNAME + "/lights");
  }

  private static String get(String url) {

    // Construct the GET request
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
        .url(url)
        .build();

    // Make the call
    try {
      Response response = client.newCall(request).execute();
      return response.body().string();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }
}

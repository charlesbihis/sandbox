#define PIN D7
int state = 0;

void setup() {
  pinMode(PIN, OUTPUT);
}

void loop() {
  digitalWrite(PIN, (state) ? HIGH : LOW);
  state = !state;
  delay(500);
}

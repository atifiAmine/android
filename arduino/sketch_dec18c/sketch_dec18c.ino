#include <Wire.h>

// Définition des broches pour les LEDs de la salle de bain et du garage
const int ledSalledeBainPin = 7;   // LED salle de bain
const int ledGaragePin = 8;        // LED garage

void setup() {
  pinMode(ledSalledeBainPin, OUTPUT);  // LED salle de bain
  pinMode(ledGaragePin, OUTPUT);      // LED garage

  Wire.begin(0x9);  // Initialiser l'interface I2C avec l'adresse 9 pour cet Arduino
  Wire.onReceive(receiveData);  // Lors de la réception des données, appeler la fonction receiveData
}

void loop() {
  // Attente de la réception des données
}

// Fonction pour recevoir les données via I2C
void receiveData(int byteCount) {
  String room = "";
  String ledState = "";

  // Lire la première partie du message (nom de la pièce)
  while (Wire.available()) {
    char c = Wire.read();
    if (c == ',') {
      break;
    }
    room += c;
  }

  // Lire la seconde partie du message (état de la LED)
  while (Wire.available()) {
    ledState += (char)Wire.read();
  }

  // Contrôler les LEDs en fonction des données reçues
  if (room == "salledebain" && ledState == "on") {
    digitalWrite(ledSalledeBainPin, HIGH);  // Allumer la LED salle de bain
  } else if (room == "salledebain" && ledState == "off") {
    digitalWrite(ledSalledeBainPin, LOW);   // Éteindre la LED salle de bain
  }

  if (room == "garage" && ledState == "on") {
    digitalWrite(ledGaragePin, HIGH);   // Allumer la LED garage
  } else if (room == "garage" && ledState == "off") {
    digitalWrite(ledGaragePin, LOW);    // Éteindre la LED garage
  }
}

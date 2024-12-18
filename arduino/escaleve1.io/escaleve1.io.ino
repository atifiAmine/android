#include <Wire.h>

// Définition des broches pour les LEDs de la chambre et du salon
const int ledChambrePin = 8;  // LED chambre
const int ledSalonPin = 13;    // LED salon

void setup() {
  pinMode(ledChambrePin, OUTPUT);  // LED chambre
  pinMode(ledSalonPin, OUTPUT);    // LED salon

  Wire.begin(0x8);  // Initialiser l'interface I2C avec l'adresse 8 pour cet Arduino
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
  if (room == "chambre" && ledState == "on") {
    digitalWrite(ledChambrePin, HIGH);  // Allumer la LED chambre
  } else if (room == "chambre" && ledState == "off") {
    digitalWrite(ledChambrePin, LOW);   // Éteindre la LED chambre
  }

  if (room == "salon" && ledState == "on") {
    digitalWrite(ledSalonPin, HIGH);   // Allumer la LED salon
  } else if (room == "salon" && ledState == "off") {
    digitalWrite(ledSalonPin, LOW);    // Éteindre la LED salon
  }
}

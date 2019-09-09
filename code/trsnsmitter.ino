#include <VirtualWire.h>
#include <stdlib.h>
const int groundpin = 18;             // analog input pin 4 -- ground
const int powerpin = 19;              // analog input pin 5 -- voltage
const int xpin = A3;                  // x-axis of the accelerometer
const int ypin = A2;                  // y-axis
const int zpin = A1;                  // z-axis

char *controller;
void setup() {
  pinMode(groundpin, OUTPUT);
  pinMode(powerpin, OUTPUT);
  digitalWrite(groundpin, LOW);
  digitalWrite(powerpin, HIGH);
  //pinMode(13,OUTPUT);.
  Serial.begin(9600);
vw_set_ptt_inverted(true); //
vw_set_tx_pin(12);
vw_setup(4000);// speed of data transfer Kbps
}

void loop(){
  int x=analogRead(xpin);
  Serial.println(x);

  
  int y=analogRead(ypin);
  Serial.println(y);
  
   //itoa (x,controller,10);
   char buf[10];
   int j=0;
  
   while(x)
   {
    buf[j]=x%10;
    x=x/10;
    Serial.print((int)buf[j]);
     j++;
    }

    while(y)
   {
    buf[j]=y%10;
    y=y/10;
    Serial.print((int)buf[j]);
     j++;
    }
    Serial.println();
  controller= buf;
 //Serial.println(controller);
 //sprintf (controller, "%03i", x);
// Serial.println((int)controller[0]);

vw_send((uint8_t *)controller, strlen(controller));
vw_wait_tx(); // Wait until the whole message is gone
delay(100);

}

#include <VirtualWire.h>

#define m11 3
#define m12 4
#define m21 5
#define m22 6


void setup()
{
  Serial.begin(9600);
  Serial.println("tset");
    vw_set_ptt_inverted(true); // Required for DR3100
    vw_set_rx_pin(12);
    vw_setup(4000);  // Bits per sec
    pinMode(13, OUTPUT);

    vw_rx_start();       // Start the receiver PLL running
}
    void loop()
{
    uint8_t buf[VW_MAX_MESSAGE_LEN];
    uint8_t buflen = VW_MAX_MESSAGE_LEN;

    if (vw_get_message(buf, &buflen)) // Non-blocking
    {
      
//Serial.print((int)buf[5]);
//Serial.print((int)buf[4]);
//Serial.println((int)buf[3]);
int y=(int)buf[5]*100+(int)buf[4]*10+(int)buf[3];
//Serial.print((int)buf[2]);
//Serial.print((int)buf[1]);
//Serial.println((int)buf[0]);
int x=(int)buf[2]*100+(int)buf[1]*10+(int)buf[1];    
  Serial.println(x);
  Serial.println(y);
  Serial.println();
  
   if(x>350)
    {
        Serial.println("forward");
        digitalWrite(m11,HIGH);
        digitalWrite(m12,LOW);
        digitalWrite(m21,HIGH);
        digitalWrite(m22,LOW);

//        delay(5000);
//        digitalWrite(m11,LOW);
//        digitalWrite(m12,LOW);
//        digitalWrite(m21,LOW);
//        digitalWrite(m22,LOW);
        
      }
      else if(x<330)
      {
        Serial.println("backward");
        digitalWrite(m11,LOW);
        digitalWrite(m12,HIGH);
        digitalWrite(m21,LOW);
        digitalWrite(m22,HIGH);    
        
        }
        else if(y>350)
    {
      Serial.println("left");
      digitalWrite(m11,HIGH);
        digitalWrite(m12,LOW);
        digitalWrite(m21,LOW);
        digitalWrite(m22,LOW);    
      
      }
      else if(y<330)
      {
        Serial.println("right");
        digitalWrite(m11,LOW);
        digitalWrite(m12,LOW);
        digitalWrite(m21,HIGH);
        digitalWrite(m22,LOW);    
      
        }    
    }
   
    //x 344
    //y 338
    //right side y is <337
    //forward x>344

   
}


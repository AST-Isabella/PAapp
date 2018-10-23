/*
The sketch demonstrates how to do accept a Bluetooth Low Energy 4
Advertisement connection with the Simblee, then send GSR or analog read
updates once a second. You may have to set your pin number.

This sketch works with SimbleeForMobile.
*/

/*This sketch is adapted from the temperature example in SimbleeForMobile examples.*/

#include <SimbleeForMobile.h>

void setup()
{
  // this is the data we want to appear in the advertisement
  // (if the deviceName and advertisementData are too long to fix into the 31 byte
  // ble advertisement packet, then the advertisementData is truncated first down to
  // a single byte, then it will truncate the deviceName)
  SimbleeForMobile.advertisementData = "GSR data";
  // start SimbleeForMobile
  SimbleeForMobile.begin();
}

bool first_sample;
uint8_t text;
unsigned long lastUpdated = 0;
unsigned long updateRate = 500; // half a second

// include newlib printf float support (%f used in sprintf below)
asm(".global _printf_float");

void loop()
{
  unsigned long loopTime = millis();
  if (SimbleeForMobile.updatable && updateRate < (loopTime - lastUpdated))
  {
    lastUpdated = loopTime;
    //Set your pin number here:
    float gsrValue=analogRead(3);
  
    // requires newlib printf float support
    char buf[16];
    sprintf(buf, "%0.2f", gsrValue);

    // update the text first with the actual temp
    SimbleeForMobile.updateText(text, buf);
  }

  // process must be called in the loop for SimbleeForMobile
  SimbleeForMobile.process();
}

void SimbleeForMobile_onConnect()
{
  first_sample = true;
}

void ui()
{
  SimbleeForMobile.beginScreen(WHITE);
  text = SimbleeForMobile.drawText(145, 240, "", BLUE, 45);
  SimbleeForMobile.endScreen();
}

void ui_event(event_t &event)
{
}

import paho.mqtt.publish as publish

publish.single("mydata/led", "led_off", hostname="172.30.1.52")
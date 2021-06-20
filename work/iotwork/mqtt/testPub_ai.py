import paho.mqtt.publish as publish

btnStatus = "android"
uuid = "driver"
busNum = "riding"
busLicenseNum = "마포역"
latitude = ""
longitude = ""

publish.single("eyeson/busTime", btnStatus + "/" + uuid + "/" + busNum + "/" + busLicenseNum + "/" + latitude + "/" + longitude + "/", hostname="15.164.46.54")
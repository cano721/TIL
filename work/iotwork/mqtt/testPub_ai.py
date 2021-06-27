import paho.mqtt.publish as publish

# btnStatus = "bigData"
# uuid = "ok"
# busNum = "L"
# busLicenseNum = "마포역"
# latitude = ""
# longitude = ""
# latitude2 = ""
# longitude2 = ""
# ongitude3 = ""

btnStatus = "ai"
uuid = "noticeInfo"
busNum = "L"
busLicenseNum = "마포역"
latitude = ""
longitude = ""
latitude2 = ""
longitude2 = ""
ongitude3 = ""
publish.single("eyeson/busTime", btnStatus + "/" + uuid + "/" + busNum + "/" + busLicenseNum + "/" + latitude + "/" + longitude + "/"+ latitude + "/" + longitude + "/" + longitude + "/", hostname="13.124.134.89")
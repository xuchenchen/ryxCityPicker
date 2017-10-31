# CityPicker

[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-9%2B-yellow.svg?style=flat)](https://android-arsenal.com/api?level=14)

现在使用比较多的类似美团等APP的城市选择界面.

2步即可实现，就是这么简单粗暴！

# Gif

![image](https://github.com/zaaach/CityPicker/raw/master/art/screen.gif)

# APK

下载[demo.apk](https://github.com/zaaach/CityPicker/raw/master/art/demo.apk)体验.


还需要添加`CityPickerActivity`

```xml
<activity
            android:name="com.zaaach.citypicker.CityPickerActivity"
            android:theme="@style/CityPicker.NoActionBar"
            android:screenOrientation="portrait"
            android:windowSoftInputMode="stateHidden|adjustPan"/>
```

### Step2:

```java
private static final int REQUEST_CODE_PICK_CITY = 0;
 Intent intent=  new Intent(MainActivity.this, CityPickerActivity.class);
                intent.putExtra("locationcity","济南市");
                intent.putExtra("locationDistrict","高新区");

                hostCitys.add("济南");
                hostCitys.add("北京");
                hostCitys.add("安阳");
                hostCitys.add("泰山");
                hostCitys.add("泰山");
                hostCitys.add("泰山");
                hostCitys.add("泰山");
                hostCitys.add("泰山");
                hostCitys.add("泰山");
                intent.putStringArrayListExtra("hotCitys",hostCitys);
                startActivityForResult(intent,
                        REQUEST_CODE_PICK_CITY);

//重写onActivityResult方法
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK){
        if (data != null){
            String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
            resultTV.setText("当前选择：" + city);
        }
    }
}
```

### Step3:

enjoy it.

# Proguard

注意混淆

```java
//定位
-keep class com.amap.api.location.**{*;}
-keep class com.amap.api.fence.**{*;}
-keep class com.autonavi.aps.amapapi.model.**{*;}
```

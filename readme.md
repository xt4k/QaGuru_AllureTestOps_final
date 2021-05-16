Here used Owner lib for different mobile platforms, devices, platforms:

Run mobile on "browserstack server" for iOS devices: gradle clean -Denv=bs_ios bs_ios_tests 

Run mobile on "browserstack server" for Android devices: gradle clean -Denv=bs_android bs_android_tests

Run mobile on "selenoid" for Android devices: gradle clean -Denv=selenoid emu_android_tests

Run web-shop api tests for "webshop.api.tests.tricentis": gradle clean shop_api_tests

Run Api tests 'search result': gradle clean search_api_tests

Run Api tests 'add Gift Cards to wishlist': gradle clean wish_api_tests

Run Api tests 'all api tests': gradle clean api_tests

Run Api test 'physical gift card api test': gradle clean -Denv=common ph_card_api_test

Run GUI test 'search button': gradle clean shop_ui_tests -Denv=common


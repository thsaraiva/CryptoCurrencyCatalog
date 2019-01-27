# CryptoCurrencyCatalog
Android app that displays a list of cryptocurrencies

## Preparation
First of all we are going to build an app that displays a list of CryptoCurrencies without using any Dependency Injection framework. The list of currencies will be generated using dummy data:

Steps:
- Add RecyclerView dependency to gradle file. ✅
- Change Activity layout to display RecyclerView ✅
- Create Model to represent Currency and helper function to create dummy data ✅
- Create RecyclerView Adapter and View Holder ✅
- Set Adapter and LayoutManager in RecyclerView ✅

## Read Currencies from local JSON file using MOSHI
- add dependency to Moshi in gradle file
- create JSONConverter class with methods that convert
    - JSON -> Currency;
    - Currency -> JSON;
    - List\<Currency\> -> JSON
    - JSON -> List\<Currency\>
- create JSON file in res/Raw folder with list of currencies
- Inside activity, change helper method to read JSON file and create JSON string
- Use JSONConverter to obtain list of currencies and pass to adapter
- try to use the `nullSafe()` method from the library

## Write UI Tests for recycler view
- test 1st element is visible
- test element that is hidden is visible after scrolling

## Search Specific Currency
- Search icon on ActionBar
- Use SearchView component

## Use Koin as DependencyInjection framework

## Use retrofit to obtain data from a Remote Repository (GitHub/Marvel)

## Implement a Logger using OkHttpInterceptor
- this can be implemented in a separate module.


package com.darnitto.dakemastores.navigation

const val ROUT_HOME = "home"
const val ROUT_ABOUT = "about"
const val ROUT_CONTACT = "contact"
const val ROUT_SERVICE = "service"
const val ROUT_NOTIFICATION = "notification"
const val ROUT_DASHBOARD = "dashboard"
const val ROUT_SPLASH = "splash"
const val ROUT_ORDER = "order"
const val ROUT_ELECTRONICS = "electronics"
const val ROUT_CATEGORY = "category"
const val ROUT_TOOLS = "tools"
const val ROUT_TOYS = "toys"
const val ROUT_FASHION = "fashion"
const val ROUT_KITCHEN = "kitchen"
const val ROUT_HEALTH = "health"
const val ROUT_BEAUTY = "beauty"
const val ROUT_SPORTS = "sports"
const val ROUT_PRODUCT_DETAIL = "product_detail/{productId}"



//Authentication
const val ROUT_REGISTER = "Register"
const val ROUT_LOGIN = "Login"

//Products6

const val ROUT_ADD_PRODUCT = "add_product"
const val ROUT_PRODUCT_LIST = "product_list"
const val ROUT_EDIT_PRODUCT = "edit_product/{productId}"

// ✅ Helper function for navigation
fun editProductRoute(productId: Int) = "edit_product/$productId"




package resources


data class StringResources(
    val beepBeep : String = "Beep Beep",
    val allMeals: String = "All meals",
    val ownerUsername: String = "Owner username",
    val address: String = "Address",
    val rating: String = "Rating",
    val priceLevel: String = "Price level",
    val restaurantName: String = "Restaurant name",
    val phoneNumber: String = "Phone number",
    val workingHours: String = "Working hours",
    val description: String = "Description",
    val save: String = "Save",
    val logout: String = "Logout",
    val restaurantNameErrorMessage: String = "restaurant name should be between 4 to 25 letters",
    val descriptionErrorMessage : String = "description shouldn't be more than 255 letter"
)
# SystemDesignItinerary

Entities folder:
Activity.java: Represents an activity included in a travel package. It contains properties such as ID, name, description, cost, capacity, destination, and the number of registrations for the activity.

Destination.java: Represents a travel destination with its associated activities. It has properties like ID, destinationName, and a list of activities available at the destination.

Passenger.java: Represents a passenger enrolled in a travel package. It includes properties such as name, passenger number, balance, passenger type (STANDARD, GOLD, or PREMIUM), and a list of enrolled activities.

PassengerType.java: An enum that represents the types of passengers (STANDARD, GOLD, or PREMIUM).

TravelPackage.java: Represents a travel package that includes multiple destinations and passengers. It has properties like ID, name, passenger capacity, a list of destinations, and a list of passengers.

Exceptions folder:

ActivityNotFoundException.java: An exception class thrown when an activity is not found.

NoBalanceException.java: An exception class thrown when a passenger has insufficient balance.

Services folder:

IPassengerService.java: An interface that defines the operations related to passenger services. It includes methods for printing passenger details, activity registration, calculating discounts, checking balance, and calculating payment amounts.

PassengerService.java: A class that implements the IPassengerService interface and provides the actual implementation for passenger-related services. It includes methods for printing passenger details, registering for activities, calculating discounts, checking balances, and calculating payment amounts.
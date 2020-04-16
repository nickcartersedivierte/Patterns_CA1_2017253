# Patterns_CA1_2017253
 Design Patterns CA1- Ana Ospitaletche

I used the creational patterns: Builder and Singletton.

The Singletton pattern I used it in my Data class, because this way, I have a global access point to the database. This class is in charge of establishing the connections to the database.

The Builder Pattern I implemented it in my Country class, because as there are so many parameters involved in creating Country objects that using the builder pattern would allow for less issues and also to implement mandatory and optional properties of the object. This way if for example a user wants to save a new country in the database they dont need to provide all properties.

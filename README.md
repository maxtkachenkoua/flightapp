# flightapp
Blueribbon backend excercise

#NOTES
Excercise was implemented as a spring boot based project without using any databases, caching libraries. 


#Flights Application Assignment

1. You have 180 minutes for this exercise
2. When finished please post link of the pushed project (e.g Bitbucket/Github) to email:
idan@bluerbn.com and ido@bluerbn.com
Create a Flight app services that handles the following requests:
Prerequisites:
Create hardcoded data that will “act” as your datasource (no need to run external/internal
databases).

a. Check if ticket is available - 6 points
a1. User Provide TicketId(Numeric) and return response (boolean) whether the ticket is
available or not (the response will determine upon your predefined static data)
b. Provide baggage check in service - 6 points
b1. User provide Destination Id(Numeric) and baggage Id(String)
Return answer if the checkin succeeded (boolean)

c. Provide Coupon support. 12 points
c1. User provide couponId(Numeric) and Price(Double)
c2. Return response if the coupon is valid. In the response the use will get the final price
after discount (10%,50%,60% - picked up randomly) in case not valid the response should
indicate that the coupon is not valid and the original price will be returned
* create random list of valid couponId's
d. Create local in-memory cache mechanism(implement your own.
Dont use any caching libs like spring caching or anything else) that caching results and add
expiration to them. (for example: if you have multiple requests that check if ticket is available
for the same request return cached results) 25 points

Architecture: - 16 points
1. Design all architecture layers
2. Design interfaces and API’s
3. Pay attention to architect the right datasource ERD’s
3. Design basic implementation of your interfaces
4 Basic validation
5. Minimum unit-testing (at least 1)
6. Loggings
7. Clean code

Technology: - 20 points
1. Use build tools: gradle/maven
2. Use application container: Spring-boot/Vert.x
3. Push your project into Github/Bitbucket account.
Compiled and Working app - 15 points

● If you don't have time to implement all requirements a working app will be highly
considered than a non-working ver.
Thanks and good luck.
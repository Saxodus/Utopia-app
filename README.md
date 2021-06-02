# Utopia-app

I created two activities (1st for user list, 2nd user details list)

I fetched only userIDs from the API's endpoint (/users) and placed them in the class UserList.

I fetched all data from the API's endpoint (/todos) and placed them in the class MainActivity.

Their xml files works fine.

Maybe it was not a proper way to do it, because I didnt know how to push forward specified data to another activity. Probably by specifying  them. (I made a class UserList, but when i launch the app, usedIds they were duplicating, like userid:1 was duplicated for 20 times, because userid:1 contains 20 IDs.. and so on..).. so I fetched the data from /users (10 userIds in total).  I know how to deal with specified data in the activities, and to share data between activities, but I didnt know to do it with fetched json data.

It would be possible to count uncompleted tasks and show them with userId (in the user list), but I didnt know how to parse them correcty. 

Thanks,

Armin


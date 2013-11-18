
Android Web Generator
 
You can convert a web page (Responsive web design) in an Android application to only use the URL of the page.
The resulting application will run smoothly at least on all android devices 2.2 or higher. 

To do this you have to download these two projects prepared for the eclipse from my GitHub repository :
 

AppWebGenerator Project
=======================

This project contains the resulting android application . You should follow these simple steps :
 
Step 1:
  - Rename the project name for the one you prefer .
  - Rename the name of pakete es.com.disastercode.appwebgenerator
  - Rename the name of pakete es.com.disastercode.appwebgenerator.menu
 
 Note : do it in this order and use refactor provided by the eclipse.
 
 
Step 2:
  Go to res / values ??/ strings.xml and give value to the following variables:
  URL_DIR - > will be the web address of the page you want to use as if it were an application.
  TITLE_APP - > title to appear on the top bar.
  myAdUnitId - > code to put admob advertising . Leave blank if you do not want to leave advertising.
 
 
Step 3:
  Replace ic_launcher.png images directories for the logo that will take your application :
  - Res / drawable - hdpi
  - Res / drawable - ldpi
  - Res / drawable - mdpi
  - Res / drawable - xhdpi
  - Res / drawable - xxhdpi
 
It is advisable to substitute other have the same size .
 


library project
===============

This project contains version 4.2 of actionbarsherlock .
More info at: http://actionbarsherlock.com/
This bar is used for the top of the application. If you want to change the color is set in the file res / drawable / background.xml
 
 



 
Example of use:
 
Web EcoDom: http://disastercode.com.es/appecodom
This is a website (responsive web design) to keep track of expenses. It is made with the Codeigniter PHP Framework with the extension Grocery Crud.
It has also been used to draw the graphical statistics JGraph the library.
 
Android App. result: https://play.google.com/store/apps/details?id=es.com.disastercode.appecodom&hl=es_419
 
 





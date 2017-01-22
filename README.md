# EXAM: Java Spring Retake

### Getting Started
 - Fork this repository under your own account
 - Clone the forked repository to your computer
 - Commit your changes frequently
 - Go through the whole description before starting it

### What can I use?
 - You can use any resource online, but **please work individually**
 - Instead of copy-pasting your answers and solutions, write them in your own words.

## The URL shortener website
Build a simple URL shortener that people can use to slim down their long URLs.

### Setup a new project
- Create a new Spring Boot project inside your cloned repository
- Setup `.gitignore` file to exclude the IDE's generated files
   - the src directory should be committed (containing all java and resource files)
   - the gradle related files should be committed
   - the gitignore should be committed
- Create a package called `com.greenfox.exams.springretake` and work under that

### Index page
- The frontend should have
    - a heading with the title of the site
    - a paragraph that describes the functionality shortly
    - a form in which you can enter the url you'd like to shorten
        - "http://index.hu/nagyon-hosszu-url-cim-meg-annal-is-hosszabb"
        - "www.blabla.com/blabla/12312443/blabla/sadsadsa/adss"

### Backend
- when data is submitted the backend should
    - check if the submitted url contains the protocol (`http` or `https`)
        - if not add "http" as default
    - generate a 6 character long random string and store it along with the url
    - render the show page
- should have an endpoint which accepts a url parameter
    - searches for the url parameter in the database to get the original url
    - redirects to the original url
    - redirects to the index page if not found

### Show page
- The frontend should have
    - a heading that contains the original url
    - a link to the shortened version (as href and as text)
    - a link back to the index page

# logpal
Create simple log files containing details of installations or other operations performed on a system, then use those logs to generate scripts which can be run on another machine, or on the same machine after a reinstall

## Intended Audience ##
* Users who like to know what changes they have made on their system, particulary on systems without package managers such as *Microsoft Windows*, where it can be more difficult to track installations
* Users who are new to Linux or another operating system and would like a simple way to keep track of installations, configurations, etc.

## Features ##
* Allow user to create simple log files in different file formats in order to keep track of changes made to a system
* Allow user to easily import recent command-line inputs on Linux systems using *Bash* and store in a log
* Allow scripts to be generated from alterations stored in logs in order to easily replicate those changes on a new system e.g. *installing git from WANdisco repository on CentOS 7*
* Provide a graphical user interface which allows user to easily view and modify logs, as well as generate install scripts

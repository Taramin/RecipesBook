# RecipesBook <a name = "header"></a>


<img src="https://thumbs.dreamstime.com/b/%D1%80%D0%B5%D0%B3%D0%B8%D1%81%D1%82%D1%80%D0%B0%D1%86%D0%B8%D1%8F-%D0%BB%D0%BE%D0%B3%D0%BE%D1%82%D0%B8%D0%BF-%D1%80%D0%B5%D0%B3%D0%B8%D1%81%D1%82%D1%80%D0%B0-%D0%B8%D0%BB%D0%B8-%D1%8F%D1%80%D0%BB%D1%8B%D0%BA-%D0%B4%D0%BD%D0%B5%D0%B2%D0%BD%D0%B8%D0%BA-%D0%B7%D0%BD%D0%B0%D1%87%D0%BE%D0%BA-%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%87%D0%B0%D0%BD%D0%B8%D1%8F-125702887.jpg" align="left" width="200" hspace="10" vspace="10">
RecipesBook is an application for posting and reading recipes.<br/> 



## Technologies <a name = "table"></a>
![JavaFX](https://img.shields.io/badge/-JavaFX-EAE5E9?style=for-the-badge&logo=JavaFX&logoColor=504099)
![JDBC](https://img.shields.io/badge/-JDBC-EAE5E9?style=for-the-badge&logo=JDBC&logoColor=504099)
![MySQL](https://img.shields.io/badge/-MySQL-EAE5E9?style=for-the-badge&logo=MySQL&logoColor=504099)


## Features <a name = "table"></a>
- Products
  - Add product
  - Change product
  - Delete product
  - View products list
- Providers
  - Add provider
  - Change provider
  - Delete provider
  - View price lists
  - View providers list
- Recipes
  - Add recipe
  - Change recipe
  - Delete recipe
  - View recipes list


## Installation <a name = "install"></a>

Clone project:
```sh
git clone https://github.com/Taramin/RecipesBook
cd {project-name}
```
#### Linux/MacOS
Add an environment variable pointing to the lib directory of the runtime:
```sh
export PATH_TO_FX=path/to/javafx-sdk-17/lib
```
Compile the application:
```sh
javac --module-path $PATH_TO_FX --add-modules javafx.controls {project-name}.java
```
Finally, run the application:
```sh
java --module-path $PATH_TO_FX --add-modules javafx.controls {project-name}
```

#### Windows
Add an environment variable pointing to the lib directory of the runtime:
```sh
set PATH_TO_FX="path\to\javafx-sdk-17\lib"
```
Compile the application:
```sh
javac --module-path %PATH_TO_FX% --add-modules javafx.controls {project-name}.java
```
Finally, run the application:
```sh
java --module-path %PATH_TO_FX% --add-modules javafx.controls {project-name}
```

## Examples <a name = "build"></a>
[Task, description, diagrams (use cases, ER, Database and classes, BPMN), commands, interface](https://github.com/Taramin/RecipesBook/blob/master/Taramin_PBZ_2.pdf)


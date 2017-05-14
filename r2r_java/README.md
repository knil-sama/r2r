## R2R

Technical coding test from french company [Xebia](https://xebia.com/)

See complete specification ExerciceTechnique-MOWER2.doc.pdf

## Motivation

Project has to run on jvm so we use a lot of language to problem (Clojure, Scala, Jython) but keep it simple

with ["boring"](http://mcfunley.com/choose-boring-technology) java

## Installation

mvn -f r2r_java/pom.xml install
## Tests

mvn -f r2r_java/pom.xml clean verify

## Compatibility

Because this program use some new features of java (as lambda) it's can be compiled to a version < 1.8

## Contributors

C.Demonchy

Pershkrim i Projektit (Sistem Menaxhimi Kursesh Online):

Ky projekt eshte nje aplikacion REST API i ndertuar me Java dhe Spring Boot, qe simulon nje platforme per menaxhimin e kurseve online, duke mbuluar funksionalitetet kryesore per:
-Administratorin
-Instruktorin
-Studentin


Autentikimi dhe Roli i Përdoruesit

Sistemi perkrah login/register me JWT token dhe ka 3 role:

-STUDENT: Mund te shohe kurset qe ofrohen dhe te regjistrohet

-INSTRUCTOR: Mund te krijoje, modifikoje dhe shohe kurset e veta

-ADMIN: Mund te shohe, editoje dhe fshije çdo student, instruktor apo kurs


Entitetet kryesore

Kursi

-llojiKursit: psh. Java, Angular, .Net etj

-pershkrimi: pershkrim i shkurter rreth kursit

-instructor: lidhje me instruktorin qe e drejton


Studenti

-emri, mbiemri, emaili

-Mund te regjistrohet ne disa kurse


Instructor

-emri, mbiemri, emaili

-Mund te kete disa kurse


Rregjistrimi

-lidhje many-to-many mes studenteve dhe kurseve

-dataRregjistrimit

-status: AKTIV, PERFUNDUAR, ANULUAR

 
Endpoint-e kryesore

Endpoint                  	               Roli	           Pershkrimi
POST /api/auth/register	                  publik	         Regjistrim përdoruesi
POST /api/auth/login	                     publik	         Login dhe kthim i token-it JWT
GET /api/student/kurset     	             STUDENT	        Shfaq te gjitha kurset
POST /api/student/rregjistrohu	           STUDENT	        Regjistrim ne nje kurs
GET /api/student/kurset-e-mia	            STUDENT	        Kurset ku eshte regjistruar studenti
POST /api/instructor/shto-kurs 	          INSTRUCTOR	     Shton nje kurs të ri
GET /api/instructor/kurset	               INSTRUCTOR	     Shfaq kurset e tij
PUT /api/instructor/kurset/[id]	          INSTRUCTOR	     Perditeson kursin e vet
GET /api/admin/kurset	                    ADMIN	          Shfaq te gjitha kurset
DELETE /api/admin/student/[id]	           ADMIN	          Fshin nje student
PUT  /api/admin/kursi/{id}	               ADMIN	          Editon nje kurs 
DELETE /api/admin/instructor/[id]         ADMIN	          Fshin nje instruktor


--Rregjistrimi ne sistem si student:

![img.png](img.png)

--Login permen Token:

![img_1.png](img_1.png)

--Printimi i te gjitha kurseve available:

![img_2.png](img_2.png)

--Rregjistrimi ne nje kurs: 

![img_3.png](img_3.png)

--Printimi i kurseve qe po ndjek (studenti):

![img_5.png](img_5.png)

--Rregjistrimi ne sistem si instruktor:

![img_6.png](img_6.png)

--Logimi permes token:

![img_7.png](img_7.png)

--Shto nje kurs (si instruktor)

![img_8.png](img_8.png)

--Rregjistrimi ne sistem si admin:

![img_9.png](img_9.png)

--logimi si admin:

![img_10.png](img_10.png)

--Printimi i kurseve (si admin):

![img_11.png](img_11.png)

--Modifikimi i nje kursi nga admini:

![img_12.png](img_12.png)

--Fshirja e nje studenti nga admini (nga id):

![img_13.png](img_13.png)

![img_14.png](img_14.png)

--Printimi i listes se studenteve te rregjistruar( nga admini):

![img_15.png](img_15.png)

--Printimi i listes se instruktoreve( nga admini):

![img_16.png](img_16.png)



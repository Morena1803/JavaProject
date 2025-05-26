Pershkrim i Projektit (Sistem Menaxhimi Kursesh Online):

Ky projekt eshte nje aplikacion REST API i ndertuar me Java dhe Spring Boot, qe simulon nje platforme per menaxhimin e kurseve online, duke mbuluar funksionalitetet kryesore per:
-Administratorin
-Instruktorin
-Studentin


Autentikimi dhe Roli i Përdoruesit
Sistemi perkrah login/register me JWT token dhe ka 3 role:
-STUDENT: Mund te shohe kurset qe ofrohen dhe te regjistrohet
-INSTRUCTOR: Mund te krijoje, modifikoje dhe shohe kurset e veta
ADMIN: Mund te shohe, editoje dhe fshije çdo student, instruktor apo kurs

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
Endpoint                  	      Roli	            Pershkrimi
POST /api/auth/register	          publik	      Regjistrim përdoruesi
POST /api/auth/login	          publik	      Login dhe kthim i token-it JWT
GET /api/student/kurset     	  STUDENT	      Shfaq te gjitha kurset
POST /api/student/rregjistrohu	  STUDENT	      Regjistrim ne nje kurs
GET /api/student/kurset-e-mia	  STUDENT	      Kurset ku eshte regjistruar studenti
POST /api/instructor/shto-kurs 	  INSTRUCTOR	  Shton nje kurs të ri
GET /api/instructor/kurset	      INSTRUCTOR	  Shfaq kurset e tij
PUT /api/instructor/kurset/{id}	  INSTRUCTOR	  Perditeson kursin e vet
GET /api/admin/kurset	          ADMIN	          Shfaq te gjitha kurset
DELETE /api/admin/student/{id}	  ADMIN	          Fshin nje student
PUT  /api/admin/kursi/{id}	      ADMIN	          Editon nje kurs 
DELETE /api/admin/instructor/{id} ADMIN	          Fshin nje instruktor


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


<<<<<<< HEAD

--Tabela Kursi:


![Screenshot (1195)](https://github.com/user-attachments/assets/9b4cf9d2-5241-46ee-957b-40689ce79d93)


![Screenshot (1196)](https://github.com/user-attachments/assets/d9d84cf3-32f7-4e97-a99f-da97a89c0776)





Kemi shtuar entitetin tjeter "Studenti" qe mban te dhenat e studenteve qe ndjekin nje kurs te caktuar dhe instruktorin e caktuar per ate kurs.

Printimi i te dhenave te tabeles Studenti me metoden GET:

![image](https://github.com/user-attachments/assets/56a363ab-9bf1-420a-9b59-926f6eef4c30)


![image](https://github.com/user-attachments/assets/964cccf5-36a7-4888-a9a1-fce3263e73c3)



Po ashtu kemi shtuar edhe entitetin Rregjistrimi, qe do te mbaje informacionin lidhes mes kurseve dhe studenteve, per rregjistrimin e ketyre te fundit

Printimi i te dhenave te tabeles rregjistrimi:


![image](https://github.com/user-attachments/assets/fc853f92-3867-4639-a09e-564d3e93e9f4)


![image](https://github.com/user-attachments/assets/ab9f89ca-5f6d-4502-8bfb-0784e5d45ac8)
=======
>>>>>>> 1b241ad (Shtova te gjithe punen e mbetur)

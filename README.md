Pershkrim i Projektit (Sistem Menaxhimi Kursesh Online):

Ky projekt perfaqeson zhvillimin e nje sistemi online per menaxhimin e kurseve dhe studenteve. Qellimi i projektit eshte te ofroje nje platforme ku studentet mund te regjistrohen ne kurse dhe instruktoret te menaxhojne materialett e tyre

Funksionalitetet e zbatuara deri tani:

Deri tani kemi krijuar dy entitetet e para, Kursi dhe Instructor dhe i kemi strukturuar ato ne layers(Controller, Service, Repository, Entity) qe synojne te ofrojne nje zgjidhje te thjeshte per ruajtjen dhe modifikimin e te dhenave per kurset dhe instruktoret që i ofrojnë ato

Entiteti Kursi: perfaqeson nje kurs të ofruar ne sistem

Entiteti Instructor: perfaqeson nje individ qe mund te ofroje nje ose me shume kurse

Marredhenia midis instruktorit dhe kurseve eshte zbatuar permes relacioneve @OneToMany / @ManyToOne, ku nje instruktor mund te kete disa kurse, dhe çdo kurs i perket nje instruktori

Kemi ndertuar API endpoints per te:

-Krijuar, lexuar, modifikuarr dhe fshire kurse

-Menaxhuar instruktoret

-Lidhur nje kurs me nje instruktor ekzistues përmes  metodave POST ose PUT nga Postman


--Tabela Instructor:


![Screenshot (1194)](https://github.com/user-attachments/assets/f52b8118-7431-4a1e-8916-d81576fbaa61)



--Tabela Kursi:


![Screenshot (1195)](https://github.com/user-attachments/assets/9b4cf9d2-5241-46ee-957b-40689ce79d93)


![Screenshot (1196)](https://github.com/user-attachments/assets/d9d84cf3-32f7-4e97-a99f-da97a89c0776)



Sapo shtova entitetin tjeter "Studenti" qe mban te dhenat e studenteve qe ndjekin nje kurs te caktuar dhe instruktorin e caktuar per ate kurs.

Printimi i te dhenave te tabeles Studenti me metoden GET:

![image](https://github.com/user-attachments/assets/5551920f-c4c4-47d1-8b9c-22249845d58d)


![image](https://github.com/user-attachments/assets/508491be-b49e-43fa-8994-af215fdfdf4f)


![image](https://github.com/user-attachments/assets/9b4e11db-45d2-4961-8cea-d6944b89b74c)


Modifikimi i te dhenave te nje studenti me metoden PUT, permes id:

![image](https://github.com/user-attachments/assets/3ba0ffdc-dfc0-4247-8bfb-6448f75433eb)

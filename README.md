# Tutorial APAP
## Authors
* **Karin Patricia** - *1806147016* - *A*
---

## Tutorial 3
### What I have learned today
Integrasi database pada project Spring Boot menggunakan JPA respository.

### Question 1
Pada class KamarDb, terdapat method findAllByHotelId , apakah kegunaan dari method tersebut? <br>
Answer:
Method findAllByHotelId berguna untuk memperoleh list 
berisi object kamar yang berasosiasi dengan sebuah ID hotel. 
Method ini meng-extend JPA Repository untuk melakukan 
select dari database kamar tanpa menggunakan query.

### Question 2
Pada class HotelController, jelaskan perbedaan method addHotelFormPage dan addHotelSubmit? <br>
Answer:
AddHotelFormPage merupakan method GET yang digunakan 
untuk membuat objek baru yaitu Hotel. 
Sedangkan addHotelSubmit merupakan method POST yang digunakan 
untuk mengambil seluruh nilai dari form yang diisi saat 
menambahkan objek baru dan memasukkan data tersebut ke dalam database.

### Question 3
Jelaskan kegunaan dari JPA Repository! <br>
Answer:
JPA Repository merupakan sebuah interface berisi method-method 
yang membantu sebuah aplikasi melakukan CRUD ke dalam database. 
Umumnya, interface ini digunakan untuk menghubungkan dan menyimpan 
sebuah objek dengan idnya ke dalam repository.

### Question 4
Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara HotelModel dan KamarModel dibuat?<br>
Answer:
Pada class HotelModel, terdapat relasi One-To-Many 
antara objek Hotel dan list objek kamar.  
Pada class KamarModel, terdapat relasi Many-To-One 
antara list objek Kamar ke setiap satu objek Hotel.

### Question 5
Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER! <br>
Answer:
FetchType merupakan module yang berada pada javax.persistence 
yang berguna untuk mengambil data dari database. 
Umumnya, penggunaan FetchType bergantung pada kardinalitas yang berlaku pada dua objek. 
Jika kardinalitas Many-To-One, maka pengambilan data menggunakan FetchType.EAGER, 
karena FetchType ini akan memuat setiap field yang ada pada child sekalipun belum dibutuhkan. 
Sedangkan kardinalitas One-To-Many, pengambilan data menggunakan FetchType.LAZY. 
CascadeType.ALL merupakan respon untuk constraint terhadap perubahan data parent terhadap child pada database. 
Jika menggunakan metode ini, maka semua perubahan data yang terjadi pada parent, akan mempengaruhi child.


### What I did not understand
- [ ] Fitur-fitur Intellij
- [ ] Penggunaan method-method JPA Repository
- [x] Penggunaaan dari beberapa syntax <br>
Beberapa penggunaan anotasi sudah dimengerti.
- [x] Masih kurang memahami anotasi Autowired <br>
Autowired berfungsi untuk menghubungkan class yang implements ke sebuah interface dan interface terkait.
Sehingga, interface tersebut dapat langsung digunakan dengan langsung mengimplementasi method dari class terkait.
---
## Tutorial 2
### What I have learned today
- Lebih mengerti mengenai @Controller dan @RequestParam serta @PathVariable

### Question 1
Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom&noTelepon=081xxx
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.<br>
Whitelabel Error Page dengan keterangan Internal Servel Error code 500. 
Hal ini terjadi karena belum ada template atau file html dari program traveloke yang bernama add-hotel.html, 
sehingga proses rendering pada class controller terjadi error.


### Question 2
Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? 
Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat.<br>
Anotasi Autowired berfungsi untuk melakukan scanning seluruh objek yang berada pada package service. 
Karena itu, interface HotelService dapat digunakan karena method-method yang diimplementasikan pada class HotelInMemoryService sudah terbaca otomatis oleh anotasi tersebut.

### Question 3
Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi. <br>
Whitelabel Error Page dengan keterangan Bad Response code 400.
Hal ini terjadi karena class controller meminta request parameter noTelepon, 
namun link tersebut tidak mengikutsertakan informasi noTelepon.

### Question 4
Jika Papa APAP ingin melihat Hotel dengan nama Papa APAP, link apa yang harus
diakses?<br>
Hotel Papa APAP sudah tersimpan dengan idHotel 1, sehingga page dapat diakses dengan link berikut.
http://localhost:8080/hotel/view?idHotel=1 atau http://localhost:8080/hotel/id-hotel/1

### Question 5
Tambahkan 1 contoh Hotel lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/hotel/viewall, apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.<br>
Link berikut merupakan [jawaban](https://drive.google.com/file/d/15QyHmJ5DKN__TLN1JwF3JQ2terPLQ6xg/view?usp=sharing) saya.

### What I did not understand
- [ ] Penggunaaan dari beberapa syntax
- [ ] Fitur-fitur Intellij
- [ ] Masih kurang memahami anotasi Autowired
---
## Tutorial 1
### What I have learned today
- Belajar untuk membuat Issue pada Git
- Memakai Intellij untuk pertama kalinya

### Github
1. Apa itu *Issue Tracker*? Apa saja masalah yang dapat diselesaikan dengan *Issue Tracker*?<br/>
*Issue Tracker* merupakan sebuah *tool* yang dapat digunakan secara kolaboratif untuk bertukar pendapat mengenai sebuah topik, menyelesaikan masalah, dan merencanakan kerja di  dalam Git.  
Issue yang ada, dapat didiskusikan kapanpun dengan tim (kolaborator) ataupun diluar tim. Beberapa masalah yang dapat diselesaikan pada *Issue Tracker* ini pada umumnya adalah sebagai berikut.
  - Mendiskusikan ide-ide baru untuk diimplementasikan
  - Menyimpan jejak dalam pengerjaan sebuah task atau progress sebuah proyek
  - Menyelesaikan atau menyetujui sebuah proposal, pertanyaan, atau bug reports

2. Apa perbedaan dari git merge dan git merge --squash?<br/>
git merge, merupakan *command* pada Git yang berfungsi untuk menggabungkan dua cabang repo dengan mendaftarkan seluruh perubahan *commit* yang ada pada sebuah cabang.
git merge --squash,  merupakan *command* pada Git yang berfungsi untuk menggabungkan dua cabang repo dan menyatukan seluruh perubahan *commit* yang ada pada sebuah cabang sehingga menjadi 1 *commit message* pada *history*.

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu
aplikasi? <br/>
- Aplikasi dapat dikerjakan dengan waktu yang lebih singkat karena setiap fitur dapat dikerjakan secara bersamaan oleh beberapa orang sekaligus.
- Perubahan pada masing-masing fitur yang dikerjakan dapat lebih mudah terlacak
### Spring
4. Apa itu library & dependency?<br/>
Library adalah kumpulan *package* yang digunakan program agar dapat berjalan. Contoh library yaitu, modules atau interface.
Dependency adalah kondisi dimana sebuah program bergantung dengan program lain agar dapat dijalankan.

5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?<br/>
- Maven menyediakan setup proyek yang sederhana dan sesuai dengan best practice
- Sesuai dengan konsep MVC pada Spring karena Maven bekerja dengan sistem model based
- Maven sesuai dengan Spring Framework untuk mengatasi dependency
- Akses yang instan atau mudah terhadap upgrade baru

Alternatif lain dari Maven:
- Red Hat Ansible Automation Platform
- Microsoft Team Foundation Server
- Jenkins
- CircleCI
- Bamboo
- Postman
- Team City
- Octopus Deploy

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?<br/>
- Pengaksesan terhadap database
- Prototyping aplikasi untuk transaksi data(CRUD)
- Mengintegrasikan sebuah aplikasi dengan sosial media dengan instan
- Pembuatan program testing

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan
@RequestParam atau @PathVariable?<br/>

@RequestParam
- Untuk mengekstrak query parameters
- Lebih baik digunakan pada web tradisional dimana data lebih banyak diserahkan melalui query abatements
- Dapat menspesifikasi default values pada parameter yang kosong

@PathVariable
- Digunakan untuk mengekstrak data yang berasal dari URI
- Lebih baik digunakan untuk RESTful web services dimana URLnya mengandung parameter nilai yang jelas

### What I did not understand
- [ ] Penggunaaan dari beberapa syntax
- [ ] Fitur-fitur Intellij


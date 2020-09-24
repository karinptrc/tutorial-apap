# Tutorial APAP
## Authors
* **Karin Patricia** - *1806147016* - *A*
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

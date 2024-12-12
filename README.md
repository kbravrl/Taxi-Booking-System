# Taxi Booking System

Taksi Rezervasyon Sistemi, kullanıcıların teslim alma ve bırakma yerlerini, sürücüleri, taksileri seçerek ve tarih, saat ve bagaj parçalarını belirterek taksi yolculuğu rezervasyonu yapmalarına olanak tanıyan Java Swing tabanlı bir masaüstü uygulamasıdır. Sistem, rezervasyonları onaylama veya iptal etme seçenekleri sunar ve bilgileri bir veritabanında depolar.

## Özellikler
- **Kullanıcı dostu GUI**: Rezervasyonları kolayca yapmak için basit ve sezgisel arayüz.
- **Konum Seçimi**: Kullanıcılar önceden tanımlanmış konumlardan başlangıç ​​ve bitiş noktalarını seçebilir.
- **Sürücü ve Taksi Seçimi**: Mevcut listelerden sürücüleri ve taksileri seçme seçeneği.
- **Teslim Alma Tarihi ve Saati**: Teslim alma tarihi ve saatini seçmek için esnek seçenekler.
- **Bagaj Ayrıntıları**: Daha iyi hizmet planlaması için bagaj parçası sayısını girin.
- **Rezervasyon Yönetimi**: Kullanıcılar gerektiğinde rezervasyonları onaylayabilir veya iptal edebilir.
- **Veritabanı Entegrasyonu**: Rezervasyonlar bağlı bir veritabanında saklanır ve yönetilir.

## Sistem Bileşenleri
- **GUI**: Masaüstü tabanlı bir kullanıcı arayüzü için Java Swing kullanılarak oluşturulmuştur.
- **Veritabanı**: Müşteri adı, taksi, şoför ve yolculuk bilgileri gibi rezervasyon ayrıntılarını depolamak için bir SQL veritabanı.
- **Arka uç**: GUI ile veritabanı arasındaki etkileşimi yöneten Java sınıfları.

## GUI İşlevselliği

- **Rezervasyon Ekle**: Kullanıcılar yeni bir taksi rezervasyonu oluşturmak için ayrıntılarını girebilir.
- **Rezervasyonu İptal Et**: Kullanıcılar adlarını ve seçilen taksi ve şoför bilgilerini kullanarak rezervasyonlarını iptal edebilir.
- **Rezervasyonları Listele**: Kullanıcılar veritabanında depolanan tüm mevcut rezervasyonları görüntüleyebilir.

## Önkoşullar

- Java Geliştirme Kiti (JDK) 11 veya üzeri
- MySQL Sunucusu
- MySQL için JDBC Sürücüsü

https://github.com/user-attachments/assets/7c1c16ed-7ef3-466c-8add-0cd34b00c1eb



package com.herdemanbarkaya.sigortasozluk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "quiz.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Kelimeler tablosunu oluştur
        db.execSQL("CREATE TABLE Words(id INTEGER PRIMARY KEY AUTOINCREMENT, word TEXT, meaning TEXT, isCorrect INTEGER)");
        // Başlangıç verilerini ekleyin
        insertInitialData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Tabloyu güncelleyin veya yeniden oluşturun
        db.execSQL("DROP TABLE IF EXISTS Words");
        onCreate(db);
    }

    private void insertInitialData(SQLiteDatabase db) {


        // Kelimeleri ekleyin
        insertWord(db, "Poliçe", "Sigorta sözleşmesi", 0);
        insertWord(db, "Prim", "Sigorta için ödenen ücret", 0);
        insertWord(db, "Tazminat", "Zararın karşılanması için yapılan ödeme", 0);
        insertWord(db, "Eksper", "Sigorta hasarını inceleyen uzman", 0);
        insertWord(db, "Risk", "Sigorta konusu olan tehlike", 0);
        insertWord(db, "Teminat", "Sigorta kapsamındaki güvenceler", 0);
        insertWord(db, "Kapsam", "Sigortanın sunduğu koruma alanı", 0);
        insertWord(db, "Muafiyet", "Sigortanın ödeme yapmadığı durumlar", 0);
        insertWord(db, "Hasar", "Sigorta konusu olan zarar", 0);
        insertWord(db, "Yıllık", "Bir yıl süreyle geçerli olan", 0);
        insertWord(db, "Sigorta", "Finansal koruma sağlayan sözleşme", 0);
        insertWord(db, "Kaza", "Ani ve beklenmedik olay", 0);
        insertWord(db, "Sorumluluk", "Bir olaydan doğan yükümlülük", 0);
        insertWord(db, "Zarar", "Maddi kayıp veya hasar", 0);
        insertWord(db, "Yatırım", "Paranın kazanç sağlamak üzere kullanılması", 0);
        insertWord(db, "Primi", "Sigorta poliçesi için ödenen ücret", 0);
        insertWord(db, "Hizmet", "Sigorta tarafından sağlanan destek", 0);
        insertWord(db, "Müşteri", "Sigorta hizmetinden yararlanan kişi", 0);
        insertWord(db, "Denetim", "Sigorta işlemlerinin kontrol edilmesi", 0);
        insertWord(db, "Dava", "Hukuki süreç sonucu verilen karar", 0);
        insertWord(db, "Sigorta Şirketi", "Sigorta poliçelerini sunan firma", 0);
        insertWord(db, "Mali Risk", "Finansal kayıp tehlikesi", 0);
        insertWord(db, "Fiyatlandırma", "Sigorta priminin belirlenmesi", 0);
        insertWord(db, "Şirket", "Sigorta hizmeti sunan kuruluş", 0);
        insertWord(db, "Hasar Raporu", "Sigorta hasarını açıklayan belge", 0);
        insertWord(db, "Saklama", "Sigorta poliçesinin korunması", 0);
        insertWord(db, "Müşteri Hizmetleri", "Sigorta şirketinin destek birimi", 0);
        insertWord(db, "Sigorta İhlali", "Sigorta sözleşmesinin ihlali", 0);
        insertWord(db, "Ek Teminat", "Ana teminat dışındaki güvence", 0);
        insertWord(db, "Acenta", "Sigorta satış temsilcisi", 0);
        insertWord(db, "Kapsama Alanı", "Sigortanın kapsamını belirleyen alan", 0);
        insertWord(db, "Sigorta Ödemesi", "Sigorta tarafından yapılan ödeme", 0);
        insertWord(db, "Müşteri Profili", "Sigorta hizmeti için müşteri bilgileri", 0);
        insertWord(db, "Sigorta Ürünleri", "Sunulan farklı sigorta türleri", 0);
        insertWord(db, "Güvence", "Sigorta tarafından sağlanan koruma", 0);
        insertWord(db, "Poliçe Süresi", "Sigorta poliçesinin geçerli olduğu süre", 0);
        insertWord(db, "Sözleşme", "Taraflar arasında yapılan anlaşma", 0);
        insertWord(db, "Poliçe Bedeli", "Sigorta poliçesinin mali değeri", 0);
        insertWord(db, "Yapılandırma", "Sigorta poliçesinin düzenlenmesi", 0);
        insertWord(db, "Ödeme Planı", "Sigorta primlerinin ödeme düzeni", 0);
        insertWord(db, "Aksaklık", "Sigorta sürecinde meydana gelen problem", 0);
        insertWord(db, "Hak Talebi", "Sigorta ödemesi için yapılan başvuru", 0);
        insertWord(db, "Geçici Poliçe", "Belirli bir süre için geçerli sigorta", 0);
        insertWord(db, "Sigorta Teminatı", "Sigortanın sağladığı güvence", 0);
        insertWord(db, "İptal", "Sigorta poliçesinin sona erdirilmesi", 0);
        insertWord(db, "Risk Yönetimi", "Sigorta risklerinin kontrolü", 0);
        insertWord(db, "İnceleme", "Sigorta hasarının detaylı kontrolü", 0);
        insertWord(db, "Cevap", "Sigorta talebine verilen yanıt", 0);
        insertWord(db, "Tazminat Bedeli", "Ödenecek zarar miktarı", 0);
        insertWord(db, "Koruma", "Sigorta tarafından sağlanan güvence", 0);
        insertWord(db, "Sistem", "Sigorta süreçlerinin yönetimi", 0);
        insertWord(db, "Sözleşme Şartları", "Sigorta poliçesinin hüküm ve koşulları", 0);
        insertWord(db, "Ödenecek Prim", "Sigorta poliçesi için ödenecek tutar", 0);
        insertWord(db, "Saklama Süresi", "Sigorta belgelerinin muhafaza süresi", 0);
        insertWord(db, "Sigorta Şartları", "Sigorta poliçesinin kuralları", 0);
        insertWord(db, "Şikayet", "Sigorta hizmeti ile ilgili yapılan başvuru", 0);
        insertWord(db, "Maliyet", "Sigorta hizmetlerinin maliyeti", 0);
        insertWord(db, "Poliçe Yenileme", "Sigorta poliçesinin süresinin uzatılması", 0);
        insertWord(db, "Güvenceler", "Sigorta tarafından sunulan korumalar", 0);
        insertWord(db, "Sigorta Desteği", "Sigorta hizmetleri ile ilgili destek", 0);
        insertWord(db, "Zarar Yönetimi", "Hasar durumunda yapılan işlemler", 0);
        insertWord(db, "Sigorta Tazminatı", "Sigorta kapsamında yapılan ödemeler", 0);
        insertWord(db, "Ayrıntı", "Sigorta poliçesi ile ilgili detaylar", 0);
        insertWord(db, "Teminat Türü", "Sigorta kapsamındaki güvence türleri", 0);
        insertWord(db, "Sigorta Politikası", "Sigorta şirketinin uyguladığı stratejiler", 0);
    }

    private void insertWord(SQLiteDatabase db, String word, String meaning, int isCorrect) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("word", word);
        contentValues.put("meaning", meaning);
        contentValues.put("isCorrect", isCorrect);
        db.insert("Words", null, contentValues);
    }
}
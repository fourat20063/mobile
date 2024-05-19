package com.example.seloger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbConnect extends SQLiteOpenHelper {

    public static final String DBNAME="data";

    public static final String Table_clients="Clients";
    //Colones de la table Client
    public static final String Client_email="email";
    public static final String Client_nom="nom";
    public static final String Client_prenom="prenom";
    public static final String Client_adresse="adresse";
    public static final String Client_ville="ville";
    public static final String Client_cp="cp";
    public static final String Client_tel="tel";
    public static final String Client_civilite="civilite";
//*********************************************************************
    public static final String Table_Annonces="Annonces";
    //Colones de la table Client
    public static final String Annonce_id="idA";
    public static final String Annonce_typeB="typeB";
    public static final String Annonce_typeA="typeA";
    public static final String Annonce_gouvernerat="gouvernerat";
    public static final String Annonce_ville="ville";
    public static final String Annonce_adresse="adresse";
    public static final String Annonce_superficie="superficie";
    public static final String Annonce_prix="prix";
    public static final String Annonce_date="date";
    public static final String Annonce_description="description";
    public static final String Annonce_nbc ="nbc";
    public static final String Annonce_etat ="etat";
    public static final String Annonce_img ="img";



    public DbConnect(@Nullable Context context) {

        super(context, DBNAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1= "CREATE TABLE IF NOT EXISTS Admins (" +
                "email TEXT PRIMARY KEY ," +
                "password TEXT)";
        String query2 = "CREATE TABLE IF NOT EXISTS Clients (" +
                "email TEXT PRIMARY KEY ," +  // Colonne email avec une contrainte PRIMARY KEY
                "nom TEXT ," +                 // Colonne nom
                "prenom TEXT ," +              // Colonne prenom
                "adresse TEXT ," +             // Colonne adresse
                "ville TEXT ," +               // Colonne ville
                "cp INTEGER ," +               // Colonne cp (code postal) de type INTEGER
                "tel INTEGER ," +              // Colonne tel (téléphone) de type INTEGER
                "civilite TEXT)";
        String query3 = "CREATE TABLE IF NOT EXISTS Annonces (" +
                "idA TEXT PRIMARY KEY ," +
                "typeB TEXT ," +
                "typeA TEXT ," +
                "gouvernerat TEXT ," +
                "ville TEXT ," +
                "adresse TEXT ," +
                "superficie INTEGER ," +
                "prix INTEGER ," +
                "date TEXT ," +
                "description TEXT ," +
                "nbc INTEGER ," +
                "etat TEXT ," +
                "img BLOB)";


        db.execSQL(query3);
        db.execSQL(query2);
        db.execSQL(query1);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Admins");
        db.execSQL("DROP TABLE IF EXISTS Clients");
        db.execSQL("DROP TABLE IF EXISTS Annonces");
    }
    public Boolean checkAdmin(String email, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Admins where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0)
            return true ;
        else
            return false;
    }

    public Boolean checkAnnonce(String idA){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Annonces where idA=? ",new String[]{idA});
        if(cursor.getCount()>0)
            return true ;
        else
            return false;
    }
    public Boolean checkClient(String email){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Clients where email=? ",new String[]{email});
        if(cursor.getCount()>0)
            return true ;
        else
            return false;
    }

    public Boolean ajouterClient(String email,String nom, String prenom, String adresse, String ville,Integer cp,Integer tel,String civilite){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(Client_email,email);
        contentValues.put(Client_nom,nom);
        contentValues.put(Client_prenom,prenom);
        contentValues.put(Client_adresse,adresse);
        contentValues.put(Client_ville,ville);
        contentValues.put(Client_cp,cp);
        contentValues.put(Client_tel,tel);
        contentValues.put(Client_civilite,civilite);
        Long result = db.insert(Table_clients,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }
    public Cursor afficheClient(String emailc){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] selectionArgs = {emailc};
        return db.rawQuery("SELECT * FROM Clients WHERE email=?", selectionArgs);
    }
    public Cursor afficheAnnonce(String idA){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] selectionArgs = {idA};
        return db.rawQuery("SELECT * FROM Annonces WHERE idA=?", selectionArgs);
    }

    public void insertAnnonce(Annonce annonce){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Annonce_id,annonce.getId());
        cv.put(Annonce_typeB,annonce.getTypeB());
        cv.put(Annonce_typeA,annonce.getTypeA());
        cv.put(Annonce_gouvernerat,annonce.getGouvernerat());
        cv.put(Annonce_ville,annonce.getVille());
        cv.put(Annonce_adresse,annonce.getAdresse());
        cv.put(Annonce_superficie,annonce.getSuperficie());
        cv.put(Annonce_prix,annonce.getPrix());
        cv.put(Annonce_date,annonce.getDate());
        cv.put(Annonce_description,annonce.getDescription());
        cv.put(Annonce_nbc,annonce.getNbc());
        cv.put(Annonce_etat,annonce.getEtat());
        cv.put(Annonce_img,annonce.getImg());
        Long result = db.insert(Table_Annonces,null,cv);

    }

    public ArrayList<Annonce> afficheAnnonces(){
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * FROM Annonces";
        Cursor cursor =db.rawQuery(query,null);
        ArrayList<Annonce> annonces= new ArrayList<>();
        while (cursor.moveToNext()){
            String idA= cursor.getString(0);
            String typeB= cursor.getString(1);
            String typeA= cursor.getString(2);
            String gouvernerat= cursor.getString(3);
            String ville= cursor.getString(4);
            String adresse= cursor.getString(5);
            int superficie= cursor.getInt(6);
            int prix= cursor.getInt(7);
            String date= cursor.getString(8);
            String description= cursor.getString(9);
            int nbc= cursor.getInt(10);
            String etat= cursor.getString(11);
            byte[] imageContent = cursor.getBlob(12);
            Annonce a= new Annonce(idA,typeB,typeA,gouvernerat,ville,adresse,superficie,prix,date,description,nbc,etat);
            a.setImg(imageContent);
            annonces.add(a);
        }
        cursor.close();
        return annonces;
    }

    public int updateAnnonce(Annonce annonce){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Annonce_id,annonce.getId());
        cv.put(Annonce_typeB,annonce.getTypeB());
        cv.put(Annonce_typeA,annonce.getTypeA());
        cv.put(Annonce_gouvernerat,annonce.getGouvernerat());
        cv.put(Annonce_ville,annonce.getVille());
        cv.put(Annonce_adresse,annonce.getAdresse());
        cv.put(Annonce_superficie,annonce.getSuperficie());
        cv.put(Annonce_prix,annonce.getPrix());
        cv.put(Annonce_date,annonce.getDate());
        cv.put(Annonce_description,annonce.getDescription());
        cv.put(Annonce_nbc,annonce.getNbc());
        cv.put(Annonce_etat,annonce.getEtat());
        int rslt =db.update(Table_Annonces,cv,"idA=?",new String[] {annonce.getId()});
        return rslt;
    }

}

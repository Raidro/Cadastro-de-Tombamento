package android.pos.unp.br.aula010101;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler;
import android.widget.Toast;

public class DBController extends SQLiteOpenHelper {
    public DBController(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Equipamento", factory, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " +
                "USUARIOS( ID INTEGER " +
                "PRIMARY KEY AUTOINCREMENT, " +
                "NOME TEXT UNIQUE, " +
                "EMAIL TEXT, " +
                "SENHA TEXT, " +
                "CONFIRMA TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE EQUIPAMENTO( " +
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " TIPO TEXT, " +
                " LOCAL TEXT, " +
                " UNIDADE TEXT, " +
                " NSERIAL TEXT, " +
                " TOMBO TEXT UNIQUE, " +
                " DATA TEXT)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +
                "USUARIOS;");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +
                "EQUIPAMENTO;");
        onCreate(sqLiteDatabase);

    }

    public boolean inserirUsuarios(String nome,
                                   String email,
                                   String senha,
                                   String confirma){

        ContentValues values = new ContentValues();
        values.put("NOME", nome);
        values.put("EMAIL", email);
        values.put("SENHA", senha);
        values.put("CONFIRMA", confirma);

        try{
            this.getWritableDatabase().
                    insertOrThrow("USUARIOS",
                            "",values);
        }catch(Exception ex){
            return false;
        }

        return true;

    }

    public boolean inserirEquipamento(String tipo,
                                   String local,
                                   String unidade,
                                   String nserial,
                                   String tombo,
                                   String data){


        ContentValues values = new ContentValues();
        values.put("TIPO", tipo);
        values.put("LOCAL", local);
        values.put("UNIDADE", unidade);
        values.put("NSERIAL", nserial);
        values.put("TOMBO", tombo);
        values.put("DATA", data);

        try{
            this.getWritableDatabase().
                    insertOrThrow("EQUIPAMENTO",
                            "",values);
        }catch(Exception ex){
            return false;
        }

        return true;

    }

}
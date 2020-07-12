package com.android.iam.sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;





public class MainActivity extends AppCompatActivity {
private Cursor cursor;
//private android.database.sqlite.SQLiteDatabase objetoDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
//cria o banco
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //tabela pessoas com os campos nome e idade
            //bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(nome VARCHAR, idade INT(3) ) ");

            //Inserir dados
            /*bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Pedro', 32) ");
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Pedro', 40) ");
*/
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('kaPedro', 40) ");
            //faz a consulta no banco de acordo com a condicao


            //busca nomes  na tabela pessoas
            //Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas ", null);

            //busca nomes  na tabela pessoas onde idade seja maior que 30 anos
            //Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas  WHERE idade <30", null);
            //busca nome pedro  na tabela pessoas onde idade seja maior que 30 anos
            //Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas  WHERE idade > 30 AND nome='Pedro'", null);


            /*



            SELECT colunas FROM tabela WHERE campo LIKE 'valor'
Nessa instrução, o "valor" pode ser informado de várias formas:

texto: Nesse caso, serão retornados todos os registros que contêm no campo buscado exatamente o "texto" informado no filtro. O funcionamento aqui é equivalente a utilizar o operador de igualdade (=);
%texto%: Serão retornados os registros que contêm no campo buscado o "texto" informado. Por exemplo, podemos buscar os nomes que contêm "Santos", ou que contêm uma sílaba ou letra específica. O registro com nome "Luis da Silva", por exemplo, contém o termo "da", então atenderia ao filtro '%da%';
%texto: Serão retornados os registros cujo valor do campo filtrado termina com o "texto" informado. O %, nesse caso, indica que pode haver qualquer valor no começo do campo, desde que ele termine com o "texto". Por exemplo, o registro com nome "Luis da Silva" atenderia ao filtro '%Silva';
texto%: Serão retornados os registros cujo valor do campo filtrado começa com o "texto" informado. Dessa vez, o % indica que após o "texto" pode haver qualquer valor. Por exemplo, o registro com nome "Luis da Silva", atenderia ao filtro 'Luis%'.
             */


            //busca os nome na tabela pessoas onde contenha no nome "Pe"
            //Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas WHERE nome LIKE '%Pe*'  ", null);

//busca os nome na tabela pessoas onde contenha no nome "kaPedro"

            //Cursor cursor = bancoDados.rawQuery("UPDATE pessoas SET idade=40 WHERE nome = 'kaPedro' " );

            // atualiza a tabela pessoas para idade 40
            //Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas WHERE nome LIKE 'kaPedro'  ", null);

           //atualiza
            //  bancoDados.execSQL("UPDATE pessoas SET idade=10 Where nome = 'kaPedro' ");

            //deleta
             //bancoDados.execSQL("DELETE FROM pessoas WHERE nome = 'kaPedro' ");
//deleta tabela pessoas
            //bancoDados.execSQL("DROP TABLE pessoas ");

            //campo id nao se repete e e auto gerado
            //bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT ,nome VARCHAR, idade INTEGER(3) ) ");


 /*bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('pedro', 40) ");
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('jose', 10) ");
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('maria', 70) ");
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('ana', 20) ");
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('cristina', 30) ");*/


            //consulta
           cursor = bancoDados.rawQuery("SELECT * FROM pessoas ", null);
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("RESULTADO - id: ", cursor.getString(indiceColunaId));
                Log.i("RESULTADO - nome: ", cursor.getString(indiceColunaNome));
                Log.i("RESULTADO - idade: ", cursor.getString(indiceColunaIdade));

                cursor.moveToNext();
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}





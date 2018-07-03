package frente_de_caixa;

import com.google.gson.Gson;
import venda.Venda;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializador {

    /**
     * Serializa um objeto e retorna um Array de bytes
     * @param objeto
     * @return Objeto serializado
     * @throws IOException
     */
    public static String paraJSON(Object objeto) {

        Gson json = new Gson();
        return json.toJson(objeto);
    }

    /**
     * Desserializa um Array de bytes e retorna um objeto novamente.
     * @param bytesArray
     * @return Objeto desserializado
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object aPartirDeJSON(byte[] bytesArray) throws IOException, ClassNotFoundException {
        try(ByteArrayInputStream b = new ByteArrayInputStream(bytesArray)){
            try(ObjectInputStream o = new ObjectInputStream(b)){
                return o.readObject();
            }
        }
    }

}
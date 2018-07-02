package serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {

    /**
     * Serializa um objeto e retorna um Array de bytes
     * @param objeto
     * @return Objeto serializado
     * @throws IOException
     */
    public static byte[] serialize(Object objeto) throws IOException {
        try(ByteArrayOutputStream b = new ByteArrayOutputStream()){
            try(ObjectOutputStream o = new ObjectOutputStream(b)){
                o.writeObject(objeto);
            }
            return b.toByteArray();
        }
    }

    /**
     * Desserializa um Array de bytes e retorna um objeto novamente.
     * @param bytesArray
     * @return Objeto desserializado
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object deserialize(byte[] bytesArray) throws IOException, ClassNotFoundException {
        try(ByteArrayInputStream b = new ByteArrayInputStream(bytesArray)){
            try(ObjectInputStream o = new ObjectInputStream(b)){
                return o.readObject();
            }
        }
    }

}
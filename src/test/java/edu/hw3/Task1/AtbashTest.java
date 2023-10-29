package edu.hw3.Task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtbashTest {

    @Test
    void decipher() {
        Atbash atbash = new Atbash();

        Assertions.assertEquals("Svool dliow!", atbash.decipher("Hello world!"));
        Assertions.assertEquals(
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw." +
                " Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi",
            atbash.decipher(
                "Any fool can write code that a computer can understand. " +
                    "Good programmers write code that humans can understand. ― Martin Fowler")
        );

    }
}

// package Tests;

// import org.junit.Test;

// import java.util.ArrayList;

// import static org.junit.Assert.*;

// /**
// * This is testing the Hand Class
// *
// * @author Laurence Lamarche-Cliche 101173070
// * @version 0.0
// */
// public class HandTest {

// @Test
// public void initialHandSizeIsNull() {
// Hand h = new Hand();
// assertNull(h.getHand());
// }

// @Test
// public void testDrawFromBag() {
// Bag b = new Bag(); // necessary to avoid null pointer exception
// Hand h = new Hand();

// // drawing one letter from the bag, case when hand size = 0
// h.drawFromBag(1);
// ArrayList<Letter> testHand = new ArrayList<Letter>();
// Letter A = new Letter(Letter.Character.A);
// testHand.add(A);
// assertEquals(1, h.getHand().size());
// assertEquals(testHand.size(), h.getHand().size());

// // this is the operation we will do at first
// Hand h2 = new Hand();
// h2.drawFromBag(7);
// assertEquals(7, h2.getHand().size());

// // this is testing second case, when 0 < hand size < 7
// h.drawFromBag(3);
// // h already has 1 letter, total should now be 4
// assertEquals(4, h.getHand().size());

// }

// }
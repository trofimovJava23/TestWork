
//Новый вид ошибки для выхода за пределы диапазона
public class OutOfRangeException extends Exception {
	
public OutOfRangeException(String ErrorText) {
	
	new InfoFrame(ErrorText);
}
}

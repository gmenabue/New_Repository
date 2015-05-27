package gior.examples.libro;

import java.util.Comparator;

public class OrdenarLibro extends Libro implements Comparator<Libro> {

	@Override
	public int compare(Libro l, Libro l1) {
	int resultado = 0;
	
	resultado = l.getTitulo().compareTo(l1.getTitulo());
	
		return resultado;
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
			Function<? super T, ? extends U> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public static <T, U> Comparator<T> comparing(
			Function<? super T, ? extends U> arg0, Comparator<? super U> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public static <T> Comparator<T> comparingDouble(
			ToDoubleFunction<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public static <T> Comparator<T> comparingInt(ToIntFunction<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public static <T> Comparator<T> comparingLong(ToLongFunction<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public static <T> Comparator<T> nullsFirst(Comparator<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public static <T> Comparator<T> nullsLast(Comparator<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<Libro> reversed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<Libro> thenComparing(Comparator<? super Libro> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U extends Comparable<? super U>> Comparator<Libro> thenComparing(
			Function<? super Libro, ? extends U> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U> Comparator<Libro> thenComparing(
			Function<? super Libro, ? extends U> arg0,
			Comparator<? super U> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<Libro> thenComparingDouble(
			ToDoubleFunction<? super Libro> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<Libro> thenComparingInt(ToIntFunction<? super Libro> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<Libro> thenComparingLong(
			ToLongFunction<? super Libro> arg0) {
		// TODO Auto-generated method stub
		return null;
	}*/

}

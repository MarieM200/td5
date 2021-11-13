package td5;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Panel{
	
	public static Iterator<Integer> panel1(int debut, int fin){
		if(fin<debut) {
			throw new IllegalStateException("La fin doit etre superieur au debut") ;
		}
		return new Iterator<Integer>(){
			int cursor = debut;
			
			@Override
			public boolean hasNext() {
	            return cursor <= fin;
	        }

			@Override
	        public Integer next() {
	            if(hasNext()) {
	                int temp = cursor;
	                cursor ++;
	                return temp;
	            }
	            throw new NoSuchElementException();
	        }
		};
	}
	
	public static Iterable<Integer> panel2(int debut, int fin) {
		if(fin<debut) {
			throw new IllegalStateException("La fin doit etre superieur au debut") ;
		}
		return new Iterable<Integer>() {
			@Override
			public Iterator<Integer> iterator() {
				return panel1(debut, fin);
			}
		};
	}
	
	public static List<Integer> panel(int debut, int fin) {
		if(fin<debut) {
			throw new IllegalStateException("La fin doit etre superieur au debut") ;
		}
		return new AbstractList<Integer>() {
			@Override
			public int size() {
				return fin-debut+1;
			}

			@Override
			public Integer get(int index) {
				return debut + index;
			}

			
			@Override
			public Iterator<Integer> iterator() {
				return panel1(debut, fin);
			}
		};
	}
}

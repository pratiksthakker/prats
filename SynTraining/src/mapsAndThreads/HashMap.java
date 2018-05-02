package mapsAndThreads;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>,
		Cloneable, Serializable {
	static final int DEFAULT_INITIAL_CAPACITY = 16;
	static final int MAXIMUM_CAPACITY = 1 << 30;

	static final float DEFAULT_LOAD_FACTOR = 0.75f;

	transient Entry[] table;

	transient int size;

	int threshold;

	final float loadFactor;

	transient volatile int modCount;

	public HashMap(int initialCapacity, float loadFactor) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal initial capacity: "
					+ initialCapacity);
		if (initialCapacity > MAXIMUM_CAPACITY)
			initialCapacity = MAXIMUM_CAPACITY;
		if (loadFactor <= 0 || Float.isNaN(loadFactor))
			throw new IllegalArgumentException("Illegal load factor: "
					+ loadFactor);

		// Find a power of 2 >= initialCapacity
		int capacity = 1;
		while (capacity < initialCapacity)
			capacity <<= 1;

		this.loadFactor = loadFactor;
		threshold = (int) (capacity * loadFactor);
		table = new Entry[capacity];
		init();
	}

	public HashMap(int initialCapacity) {
		this(initialCapacity, DEFAULT_LOAD_FACTOR);
	}

	public HashMap() {
		this.loadFactor = DEFAULT_LOAD_FACTOR;
		threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
		table = new Entry[DEFAULT_INITIAL_CAPACITY];
		init();
	}

	public HashMap(Map<? extends K, ? extends V> m) {
		this(Math.max((int) (m.size() / DEFAULT_LOAD_FACTOR) + 1,
				DEFAULT_INITIAL_CAPACITY), DEFAULT_LOAD_FACTOR);

	}

	// internal utilities

	void init() {
	}

	static int hash(int h) {
		// This function ensures that hashCodes that differ only by
		// constant multiples at each bit position have a bounded
		// number of collisions (approximately 8 at default load factor).
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	static int indexFor(int h, int length) {
		return h & (length - 1);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	final Entry<K, V> getEntry(Object key) {
		int hash = (key == null) ? 0 : hash(key.hashCode());
		for (Entry<K, V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
			Object k;
			if (e.hash == hash
					&& ((k = e.key) == key || (key != null && key.equals(k))))
				return e;
		}
		return null;
	}

	public V put(K key, V value) {

		int hash = hash(key.hashCode());
		int i = indexFor(hash, table.length);
		for (Entry<K, V> e = table[i]; e != null; e = e.next) {
			Object k;
			if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
				V oldValue = e.value;
				e.value = value;
				e.recordAccess(this);
				return oldValue;
			}
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modCount++;
		addEntry(hash, key, value, i);
		return null;
	}

	void resize(int newCapacity) {
		System.out
				.println("resize----------------------------------------------------started");
		Entry[] oldTable = table;
		int oldCapacity = oldTable.length;
		if (oldCapacity == MAXIMUM_CAPACITY) {
			threshold = Integer.MAX_VALUE;
			return;
		}

		Entry[] newTable = new Entry[newCapacity];
		transfer(newTable);
		table = newTable;
		threshold = (int) (newCapacity * loadFactor);
	}

	void transfer(Entry[] newTable) {
		int count = 0;
		Entry[] src = table;
		int newCapacity = newTable.length;
		System.out.println("newCapacity : --==--" + newCapacity);
		for (int j = 0; j < src.length; j++) {
			Entry<K, V> e = src[j];
			if (e != null) {
				src[j] = null;
				do {
					count++;
					Entry<K, V> next = e.next;
					int i = indexFor(e.hash, newCapacity);
					e.next = newTable[i];
					newTable[i] = e;
					e = next;
					System.out.println("data: " + newTable[i] + " "
							+ Thread.currentThread().getName());
					if (count == 5) {
						try {

							Thread.sleep(5000);

						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} while (e != null);
			}
		}
	}

	final Entry<K, V> removeMapping(Object o) {
		if (!(o instanceof Map.Entry))
			return null;

		Map.Entry<K, V> entry = (Map.Entry<K, V>) o;
		Object key = entry.getKey();
		int hash = (key == null) ? 0 : hash(key.hashCode());
		int i = indexFor(hash, table.length);
		Entry<K, V> prev = table[i];
		Entry<K, V> e = prev;

		while (e != null) {
			Entry<K, V> next = e.next;
			if (e.hash == hash && e.equals(entry)) {
				modCount++;
				size--;
				if (prev == e)
					table[i] = next;
				else
					prev.next = next;
				e.recordRemoval(this);
				return e;
			}
			prev = e;
			e = next;
		}

		return e;
	}

	static class Entry<K, V> implements Map.Entry<K, V> {
		final K key;
		V value;
		Entry<K, V> next;
		final int hash;

		/**
		 * Creates new entry.
		 */
		Entry(int h, K k, V v, Entry<K, V> n) {
			value = v;
			next = n;
			key = k;
			hash = h;
		}

		public final K getKey() {
			return key;
		}

		public final V getValue() {
			return value;
		}

		public final V setValue(V newValue) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}

		public final boolean equals(Object o) {
			if (!(o instanceof Map.Entry))
				return false;
			Map.Entry e = (Map.Entry) o;
			Object k1 = getKey();
			Object k2 = e.getKey();
			if (k1 == k2 || (k1 != null && k1.equals(k2))) {
				Object v1 = getValue();
				Object v2 = e.getValue();
				if (v1 == v2 || (v1 != null && v1.equals(v2)))
					return true;
			}
			return false;
		}

		public final int hashCode() {
			return (key == null ? 0 : key.hashCode())
					^ (value == null ? 0 : value.hashCode());
		}

		public final String toString() {
			return getKey() + "=" + getValue();
		}

		void recordAccess(HashMap<K, V> m) {
		}

		void recordRemoval(HashMap<K, V> m) {
		}
	}

	void addEntry(int hash, K key, V value, int bucketIndex) {
		System.out.println("inside add entry: "
				+ Thread.currentThread().getName());
		Entry<K, V> e = table[bucketIndex];
		table[bucketIndex] = new Entry<K, V>(hash, key, value, e);
		if (size++ >= threshold) {
			System.out.println("Size ========== " + size);
			resize(2 * table.length);
		}
	}

	private abstract class HashIterator<E> implements Iterator<E> {
		Entry<K, V> next; // next entry to return
		int expectedModCount; // For fast-fail
		int index; // current slot
		Entry<K, V> current; // current entry

		HashIterator() {
			expectedModCount = modCount;
			if (size > 0) { // advance to first entry
				Entry[] t = table;
				while (index < t.length && (next = t[index++]) == null)
					;
			}
		}

		public final boolean hasNext() {
			return next != null;
		}

		final Entry<K, V> nextEntry() {
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();
			Entry<K, V> e = current = next;
			if (e == null)
				throw new NoSuchElementException();

			if ((next = e.next) == null) {
				Entry[] t = table;
				while (index < t.length && (next = t[index++]) == null)
					;
			}
			return e;
		}

		public void remove() {

		}

	}

	private final class ValueIterator extends HashIterator<V> {
		public V next() {
			return nextEntry().value;
		}
	}

	private final class KeyIterator extends HashIterator<K> {
		public K next() {
			return nextEntry().getKey();
		}
	}

	private final class EntryIterator extends HashIterator<Map.Entry<K, V>> {
		public Map.Entry<K, V> next() {
			return nextEntry();
		}
	}

	// Subclass overrides these to alter behavior of views' iterator() method
	Iterator<K> newKeyIterator() {
		return new KeyIterator();
	}

	Iterator<V> newValueIterator() {
		return new ValueIterator();
	}

	Iterator<Map.Entry<K, V>> newEntryIterator() {
		return new EntryIterator();
	}

	// Views

	private transient Set<Map.Entry<K, V>> entrySet = null;

	public Set<K> keySet() {
		Set<K> ks = keySet;
		return (ks != null ? ks : (keySet = new KeySet()));
	}

	private final class KeySet extends AbstractSet<K> {
		public Iterator<K> iterator() {
			return newKeyIterator();
		}

		public int size() {
			return size;
		}

	}

	public Collection<V> values() {
		Collection<V> vs = values;
		return (vs != null ? vs : (values = new Values()));
	}

	private final class Values extends AbstractCollection<V> {
		public Iterator<V> iterator() {
			return newValueIterator();
		}

		public int size() {
			return size;
		}

	}

	public Set<Map.Entry<K, V>> entrySet() {
		return entrySet0();
	}

	private Set<Map.Entry<K, V>> entrySet0() {
		Set<Map.Entry<K, V>> es = entrySet;
		return es != null ? es : (entrySet = new EntrySet());
	}

	private final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
		public Iterator<Map.Entry<K, V>> iterator() {
			return newEntryIterator();
		}

		public int size() {
			return size;
		}
	}

	private static final long serialVersionUID = 362498820763181265L;

	int capacity() {
		return table.length;
	}

	float loadFactor() {
		return loadFactor;
	}
}

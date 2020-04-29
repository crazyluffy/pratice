package org.renm;

public class KVKey {
    Class k;
    Class v;

    public KVKey(Class k, Class v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KVKey kvKey = (KVKey) o;

        if (!k.equals(kvKey.k)) return false;
        return v.equals(kvKey.v);
    }

    @Override
    public int hashCode() {
        int result = k.hashCode();
        result = 31 * result + v.hashCode();
        return result;
    }
}

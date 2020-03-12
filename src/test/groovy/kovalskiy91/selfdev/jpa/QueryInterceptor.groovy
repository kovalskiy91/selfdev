package kovalskiy91.selfdev.jpa

import org.hibernate.EmptyInterceptor

class QueryInterceptor extends EmptyInterceptor {
    static def allQueries = new ArrayList<>()
    static def nextValQueries = new ArrayList<>()
    static def selectQueries = new ArrayList<>()

    static void clean() {
        allQueries.clear()
        nextValQueries.clear()
        selectQueries.clear()
    }

    @Override
    String onPrepareStatement(String sql) {
        allQueries.add(sql)
        if (sql.startsWith("select nextval")) {
            nextValQueries.add(sql)
        } else if (sql.startsWith("select")) {
            selectQueries.add(sql)
        }
        return sql
    }

}

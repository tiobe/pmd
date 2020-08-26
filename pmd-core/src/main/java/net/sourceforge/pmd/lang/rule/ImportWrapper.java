/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.rule;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import net.sourceforge.pmd.lang.ast.Node;

/**
 * @deprecated This class is only useful for Java rules and should not have been added to pmd-core.
 *             It will be removed with PMD 7.
 */
@Deprecated
public class ImportWrapper {
    private Node node;
    private String name;
    private String fullname;
    private boolean isStaticDemand;
    private Set<String> allDemands = new HashSet<>();

    public ImportWrapper(String fullname, String name) {
        this(fullname, name, null);
    }

    public ImportWrapper(String fullname, String name, Node node) {
        this(fullname, name, node, false);
    }

    public ImportWrapper(String fullname, String name, Node node, Class<?> type, boolean isStaticDemand) {
        this(fullname, name, node, isStaticDemand);
        if (type != null) {
            for (Method m : type.getMethods()) {
                allDemands.add(m.getName());
            }
            for (Field f : type.getFields()) {
                allDemands.add(f.getName());
            }
            // also consider static fields, that are not public
            for (Field f : type.getDeclaredFields()) {
                if (Modifier.isStatic(f.getModifiers())) {
                    allDemands.add(f.getName());
                }
            }
            // and methods, too
            for (Method m : type.getDeclaredMethods()) {
                if (Modifier.isStatic(m.getModifiers())) {
                    allDemands.add(m.getName());
                }
            }
        }
    }

    public ImportWrapper(String fullname, String name, Node node, boolean isStaticDemand) {
        this.fullname = fullname;
        this.name = name;
        this.node = node;
        this.isStaticDemand = isStaticDemand;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other.getClass() == ImportWrapper.class) {
            ImportWrapper i = (ImportWrapper) other;

            if (isStaticDemand != i.isStaticDemand) {
                return false;
            }

            if (name == null) {
                return fullname.equals(i.getFullName());
            }
            return name.equals(i.getName());
        }
        return false;
    }

    public boolean matches(ImportWrapper i) {
        if (isStaticDemand) {
            if (allDemands.contains(i.fullname)) {
                return true;
            }
        }
        if (name == null && i.getName() == null) {
            return i.getFullName().equals(fullname);
        }
        return i.getName().equals(name);
    }

    @Override
    public int hashCode() {
        if (name == null) {
            return Objects.hash(fullname, isStaticDemand);
        }
        return Objects.hash(name, isStaticDemand);
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullname;
    }

    public Node getNode() {
        return node;
    }

    public boolean isStaticOnDemand() {
        return isStaticDemand;
    }

    @Override
    public String toString() {
        return "Import[name=" + name + ",fullname=" + fullname + ",static*=" + isStaticDemand + ']';
    }
}

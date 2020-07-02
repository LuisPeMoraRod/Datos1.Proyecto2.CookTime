package com.Datos1.Proyecto2.CookTime.Trees;

/**
 * This class abstractize a node from a BST
 *
 * @author moniwaterhouse
 * @since 06/20/2020
 *
 * @param <T> allows the use of generics
 */

public class Node<T extends Comparable<T>> {

    T element;
    Node<T> left;
    Node<T> right;

    public Node(T element){
        this(element, null, null);
    }

    /**
     * Constructs the node with its children
     * @param element
     * @param left
     * @param right
     */

    public Node(T element, Node<T> left, Node<T> right){
        this.element = element;
        this.left = left;
        this.right = right;
    }
}

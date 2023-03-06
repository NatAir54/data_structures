package com.studying.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleLinkedListTest extends AbstractListTest {
    @Override
    protected List getList() {
        return new SimpleLinkedList();
    }


}

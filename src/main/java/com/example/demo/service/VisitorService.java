package com.example.demo.service;

import com.example.demo.model.Visitor;
import java.util.*;

public interface VisitorService {
    Visitor createVisitor(Visitor v);
    Visitor getVisitor(Long id);
    List<Visitor> getAllVisitors();
}
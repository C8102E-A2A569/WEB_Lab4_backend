package com.example.lab4.service;

import com.example.lab4.exceptions.InvalidParamsException;
import com.example.lab4.model.HitEntity;
import org.springframework.stereotype.Service;

@Service
public class HitService {
    public HitEntity check(HitEntity hit) throws InvalidParamsException {
        if (hit.getX() == null || hit.getY() == null || hit.getR() == null) {
            throw new InvalidParamsException("One or more coordinates are not defined!");
        }
        if (hit.getR() <= 0) {
            throw new InvalidParamsException("The radius is not positive!");
        }
        double start = System.nanoTime();
        hit.setAttemptTime(System.currentTimeMillis());
//        треугольник || прямоугольник || сектор
        hit.setHit((hit.getX() >= 0 && hit.getY() >= 0 && 2* hit.getY() <= hit.getR() - hit.getX())
                || (hit.getX() <= 0 && hit.getY() >= 0 && hit.getY() <= hit.getR() && hit.getX() >= - hit.getR() / 2)
                || (hit.getX() <= 0 && hit.getY() <= 0
                && hit.getY() * hit.getY() + hit.getX() * hit.getX() <= hit.getR() * hit.getR() / 4));
        hit.setExecutionTime(System.nanoTime() - start);
        return hit;
    }
}

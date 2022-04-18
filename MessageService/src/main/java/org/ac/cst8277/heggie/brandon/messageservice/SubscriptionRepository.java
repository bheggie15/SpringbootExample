package org.ac.cst8277.heggie.brandon.messageservice;

import org.ac.cst8277.heggie.brandon.messageservice.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

     List<Subscription> findSubscriptionsBySubscriberID(Long subscriberID);
}

package services.demographics

import domain.demographics.Gender
import org.scalatest.FunSuite

import scala.concurrent.Await
import scala.concurrent.duration._

class GenderServicesTest extends FunSuite {

  val entity = Gender("1","Male")
  val service = GenderService
  test("createEntity"){
    val result = Await.result(service.roach.saveEntity(entity), 2 minutes)
    assert(result)

  }

  test("readEntity"){
    val result = Await.result(service.roach.getEntity(entity.genderId), 2 minutes)
    assert(result.head.genderId==entity.genderId)
  }

  test("createEntities"){
    val result = Await.result(service.roach.getEntities, 2 minutes)
    assert(result.nonEmpty)
  }

  test("updateEntities"){
    val updatedEntity=entity.copy(genderName = "Female")
    Await.result(service.roach.saveEntity(updatedEntity), 2 minutes)
    val result = Await.result(service.roach.getEntity(entity.genderId), 2 minutes)
    assert(result.head.genderName==updatedEntity.genderName)
  }


  test("deleteEntities"){
    Await.result(service.roach.deleteEntity(entity), 2 minutes)
    val result = Await.result(service.roach.getEntity(entity.genderId), 2 minutes)
    assert(result.isEmpty)

  }
}

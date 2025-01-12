package services.users

import domain.users.UserApplicationResult
import org.scalatest.FunSuite

import scala.concurrent.Await
import scala.concurrent.duration._


class UserApplicationResultServiceTest extends FunSuite{
  val entity = UserApplicationResult("1","It's nice")
  val roachService = UserApplicationResultService
  test("createEntity"){
    val result = Await.result(roachService.roach.saveEntity(entity), 2 minutes)
    assert(result)

  }

  test("readEntity"){
    val result = Await.result(roachService.roach.getEntity(entity.userApplicationResultId), 2 minutes)
    assert(result.head.userApplicationResultId==entity.userApplicationResultId)
  }

  test("createEntities"){
    val result = Await.result(roachService.roach.getEntities, 2 minutes)
    assert(result.nonEmpty)
  }

  test("updateEntities"){
    val updatedEntity=entity.copy(description = "It's very nice")
    Await.result(roachService.roach.saveEntity(updatedEntity), 2 minutes)
    val result = Await.result(roachService.roach.getEntity(entity.userApplicationResultId), 2 minutes)
    assert(result.head.description==updatedEntity.description)
  }


  test("deleteEntities"){
    Await.result(roachService.roach.deleteEntity(entity), 2 minutes)
    val result = Await.result(roachService.roach.getEntity(entity.userApplicationResultId), 2 minutes)
    assert(result.isEmpty)

  }
}